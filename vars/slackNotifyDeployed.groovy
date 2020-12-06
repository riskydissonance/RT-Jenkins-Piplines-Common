#!/usr/bin/env groovy

def call(String repo){
    slackNotify("${JOB_NAME} for ${params.ProjectID} to <${env.BUILD_URL}https://artifactory.jmpesp.local/engagements/${params.ProjectID}/${JOB_NAME}/|artifactory>")
}
