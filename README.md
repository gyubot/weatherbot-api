# Weatherbot API

### Java SDK Install

```bash
$ curl -s "https://get.sdkman.io" | bash
$ source "$HOME/.sdkman/bin/sdkman-init.sh"
$ sdk install java 17.0.5-zulu
$ sdk use java 17.0.5-zulu
```

### 테스트

```bash
# 전체 테스트
$ ./gradlew test
```

### Run

```bash
# 서버 실행
$ ./gradlew weatherbot:api:bootRun
```

### Request

```
curl "http://localhost:8080/summary?lat=89&lon=-180"
```
