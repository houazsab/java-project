pipeline{
    agent any
    stages{
        stage('test'){
                    steps {
                        bat 'mvn test'
                        junit 'target/surefire-reports /*.xml'
                        cucumber reportTitle: 'My report',
                                 fileIncludePattern: 'target/example-report.json'

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
