pipeline {

    agent any

    stages {
        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Tests') {
            steps {
                script {
                    def tags = env.FEATURE
                    try {
                        echo "########################################\n" +
                             "#                                      #\n" +
                             "#          EVIDENCIA DE TESTES         #\n" +
                             "#                                      #\n" +
                             "########################################\n"
                        echo "Está em execução a tag = ${tags}"
                        sh "mvn test -Dcucumber.options='--tags @${tags} --tags ~@failed'"
                        echo "########################################\n" +
                            "#                                      #\n" +
                            "#            FIM DOS TESTES            #\n" +
                            "#                                      #\n" +
                            "########################################\n"

                    } catch (err) {
                        echo err.message
                    }
                }
                echo currentBuild.result
            }
        }
    }
    post {
        always {
            allure includeProperties: false, jdk: 'JDK 8', results: [[path: 'target/allure-results']]
        }
    }
}


