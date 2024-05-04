# modu-store-main-api
가게 정보를 제공하는 API 서버


## Using
- Kotlin 1.8.22
- JDK 17
- Spring Framework 3
    - Spring Boot Web
    - Spring Boot Data JPA
- Test Framework
    - KoTest
    - Mockk

## Swagger Doc
- http://localhost:8080/swagger-ui/index.html

## Coding Convention
- [ktlint](https://github.com/jlleitschuh/ktlint-gradle)
- [ktlint-gradle](https://github.com/jlleitschuh/ktlint-gradle)

```shell
# 아래 명령어를 수행하여 git commit 전에 코드 체크가 될 수 있도록 권장
./gradlew addKtlintCheckGitPreCommitHook
```

## Database
- project 에 포함된 `mysql-store.sh` 을 실행하면 mysql db 가 docker container 로 실행된다.
- 그 후에 아래 명령어를 통해 로컬 db 및 user 를 설정 해준다.

```shell
# 아래 명령어로 mysql container 에 접속
docker exec -it mysql-store mysql -uroot -pselling!
```

```sql
-- 아래 명령어로 db 및 user 생성
CREATE DATABASE modu DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'store'@'localhost' IDENTIFIED BY 'selling!';
CREATE USER 'store'@'%' IDENTIFIED BY 'selling!';

GRANT ALL PRIVILEGES ON modu.* TO 'store'@'localhost';
GRANT ALL PRIVILEGES ON modu.* TO 'store'@'%';
FLUSH PRIVILEGES;
```