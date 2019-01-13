plugins {
    id 'java'
}

dependencies {
    compile 'io.swagger:swagger-annotations:1.5.17'
    testCompile 'com.squareup.okhttp:okhttp:2.7.5'
    testCompile 'com.squareup.okhttp:logging-interceptor:2.7.5'
    testCompile 'com.google.code.gson:gson:2.8.1'
    testCompile 'io.gsonfire:gson-fire:1.8.0'
    testCompile group : 'org.apache.oltu.oauth2',
    name: 'org.apache.oltu.oauth2.client', version: '1.0.1'
    testCompile 'junit:junit:4.12'
}
