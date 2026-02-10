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
                      when{
                        branch 'master'
                      }
                      steps {
                          bat 'docker-compose up --build -d'
                      }
        }
    }
}
