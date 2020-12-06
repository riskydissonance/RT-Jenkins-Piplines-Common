def call(String gitlabWebhookToken){

    post {
        failure {
            updateGitlabCommitStatus name: 'build', state: 'failed'
        }
        success {
            updateGitlabCommitStatus name: 'build', state: 'success'
        }
    }

    options {

        timestamps()

        buildDiscarder(logRotator(numToKeepStr: '5'))

        gitLabConnection('Gitlab')

    }

    triggers {
        gitlab(triggerOnPush: true, triggerOnMergeRequest: true, branchFilterType: 'All', secretToken: gitlabWebhookToken)
    }

}
