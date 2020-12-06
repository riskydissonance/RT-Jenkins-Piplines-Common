#!/usr/bin/env groovy

def call(String repo){
    slackNotify("${JOB_NAME} for ${params.projectId} deployed to <https://artifactory.jmpesp.local/ui/repos/tree/General/engagements%2F${params.projectId}%2F${JOB_NAME}%2F|artifactory>. <${env.BUILD_URL}|Check build>.")
}
