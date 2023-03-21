pipeline {

    agent any

    options {
        office365ConnectorWebhooks(
        [[name: 'automationDesktopWinium',
        notifyBackToNormal: true,
        notifyFailure: true,
        notifySuccess: true,
        notifyUnstable: true,
        notifyRepeatedFailure: true,
        url: 'https://yamantecnologialtda.webhook.office.com/webhookb2/7e23d6b8-cf54-43b6-964e-de399af80169@b4e1747f-fa7f-4899-b109-363f70af9b4c/JenkinsCI/7f4a678f880b4ce995e0a72c35be3a03/d2fa3f5d-5194-4b72-8321-9580f1c0963e']])
    }

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


