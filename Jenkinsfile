pipeline{
    agent any
    stages{
        stage('test'){
                    steps {
                        bat 'mvn test'
                        junit 'target/surefire-reports *//*.xml'
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
                        bat './mvnw javadoc:javadoc'
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
                        bat './mvnw package'
                        archiveArtifacts 'target/*.jar'
                    }
        }
        /* stage('init'){
            steps {
                bat './mvnw clean'
            }
        } */
         /* stage('test'){
            steps {
                bat './mvnw test'
                junit 'target/surefire-reports *//*.xml'
            }
        } */
        /* stage('documentation'){
            steps {
                bat './mvnw javadoc:javadoc'
                publishHTML ([
                 allowMissing: false,
                 alwaysLinkToLastBuild: true,
                 keepAll: true,
                 reportDir: 'target/site/apidocs',
                 reportFiles: 'index.html',
                 reportName: 'Documentation'
                 ])
            }
        } */
       /* stage('build'){
            steps {
                bat './mvnw package'
                archiveArtifacts 'target/*.jar'
            }*/
            /* post{
                 *//* always{
                    emailext(subject: "Build réussi:",
                            body:"Le build a réussi."
                            to: "rina.ra.1804@gmail.com"
                            )
                    } *//*
                failure{
                        mail(subject: "Build echec:",
                                body:"Le build a réussi.",
                                to: "rina.ra.1804@gmail.com"
                                )
                }
                success{
                        mail(subject: "Build réussi:",
                                    body:"Le build a réussi.",
                                    to: "rina.ra.1804@gmail.com"
                                    )
                }
            } */
       // }
        /*stage('deploy'){
              when{
                branch 'main'
              }
              steps {
                  bat 'docker-compose up --build -d'
              }
        }*/
    }
}
