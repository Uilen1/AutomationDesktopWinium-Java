pipeline {

    agent any

    stages {
        stage('Clean & Build') {
            steps {
                bat 'mvn clean'
            }
        }
        stage('Configure Remote Machine') {
                    steps {
                        echo 'Fechando winAppDriver existentes'
                        bat 'src/test/resources/exec/kill_winappdriver.cmd'
                        echo 'Realizando logout da maquina remota'
                        bat 'src/test/resources/exec/logout-rdp.cmd'
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
                        bat "mvn test -Dcucumber.filter.tags='${tags}'"
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
            allure includeProperties: false,
            jdk: '',
            results: [[path: 'target/allure-results']]
        }
    }
}


