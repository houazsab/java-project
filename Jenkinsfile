pipeline{
    agent any
    stages{
        stage('test'){
                    steps {
                        bat 'mvn test'
                        junit 'target/surefire-reports/*.xml'
                        cucumber reportTitle: 'My report',
                                 fileIncludePattern: 'target/example-report.json'
                        recordCoverage(tools: [[parser: 'JACOCO']],
                            id: 'jacoco', name: 'JaCoCo Coverage',
                            sourceCodeRetention: 'EVERY_BUILD',
                            qualityGates: [
                                [threshold: 80.0, metric: 'LINE', baseline: 'PROJECT', unstable: true],
                                [threshold: 80.0, metric: 'BRANCH', baseline: 'PROJECT', unstable: true]])
                    }
        }
        stage('documentation'){
                    steps {
                        bat 'mvn javadoc:javadoc'
                        publishHTML ([
                         allowMissing: false,
                         alwaysLinkToLastBuild: true,
                         keepAll: true,
                         reportDir: 'target/site/apidocs',
                         reportFiles: 'index.html',
                         reportName: 'Documentation'
                         ])
                    }
        }
        stage('build'){
                    steps {
                        bat 'mvn package'
                        archiveArtifacts 'target/*.jar'
                    }
        }
        stage('deploy'){
                     /* when{
                        branch 'master'
                      }*/
                     steps {
                          //bat 'docker-compose up --build -d'
                          bat 'mvn deploy'
                      }
        }
        stage('notification') {
            parallel{
                stage('slack') {
                   steps {
                   powershell '''
                   $payload = @{ text = "Build #$env:BUILD_NUMBER finished: $env:BUILD_STATUS" } | ConvertTo-Json
                   Invoke-RestMethod -Uri $env:slackwebhook -Method Post -ContentType "application/json" -Body $payload
                   '''
                   }
                }
                stage('mail') {
                    steps {
                         mail(subject: "Build réussi:",
                              body:"Le build a réussi.",
                              to: "houazenesabrina@gmail.com"
                         )
                    }
                }
            }
        }
        stage('release') {
                steps {
                    bat"""git tag -a v1.0. -m "Release version 1.0"
                           git push origin v1.0"""

                    bat """
                           curl -X POST https://api.github.com/repos/issadlounis/untitled/releases ^
                           -H "Authorization: Bearer TOKEN" ^
                           -H "Accept: application/vnd.github+json" ^
                           -H "Content-Type: application/json" ^
                           -d "{\\"tag_name\\":\\"v%VERSION%\\",\\"name\\":\\"Release v%VERSION%\\",\\"body\\":\\"Production release\\",\\"draft\\":false,\\"prerelease\\":false}"
                        """
                }  
        }
    }
}
