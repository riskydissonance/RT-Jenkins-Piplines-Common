#!/usr/bin/env groovy

def call(String repo){
    slackNotify("${JOB_NAME} for ${params.ProjectID} deployed to <https://artifactory.jmpesp.local/engagements/${params.ProjectID}/${JOB_NAME}/|artifactory>. <${env.BUILD_URL}|Check build>")
}
