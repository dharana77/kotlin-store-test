# modu-sStore
모두의 가게를 스프링 기반으로 구현합니다.

## 모두의 가게란?

2017-2018년 경 소프트마에스트로 과정을 신청하며 냈던 신청란에 진행하고 싶은 프로젝트가 있다면? 에 제출했던 프로젝트입니다.
추후 배달의 민족이 민족이 성공하는 것을 보며 제가 생각했던 아이디어와 비슷하나 조금 다른,
오프라인 가게들을 방문 하기 전 모든 정보를 공유할 수 있고 사장님들이 가게에 대한 업데이트를 하면 고객들이 실시간으로 확인할 수 있는,
고객이 좀더 방문하거나 주문하는 가게들에 대한 정보를 더 직접적으로 잘 알 수 있는 플랫폼이 있다면 어떤 효과가 있을까 궁금하여 시작된
프로젝트입니다.
예를 들어 가게 사장님들은 팔로잉/알림 허용등을 설정한 고객들에게 업데이트 등의 알림을 보내거나 고객들이 가게를 방문하기 전
알고 싶어하는 정보 혹은 가게에 대한 모든 정보(그날의 재료입고, 오늘의 메뉴 등) 를 확인할 수 있도록 하는 것이 목표였습니다.
또한 추가적으로 거리뷰와 같은 시스템으로 3d 카메라 뷰를 통해 방문 한 것과 보다 실제 가게가 어떻게 생겼는지를 느낄 수 있게 하는 것도 추가하고 싶었습니다.

당시 자바 스프링을 고려했으나 처음부터 구축시 코틀린 스프링이 좋다는 것을 체험하게 되며 코프링 -> 자바로 구현해보기로 생각했습니다.



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
- project 에 포함된 `mysql-moon.sh` 을 실행하면 mysql db 가 docker container 로 실행된다.
- 그 후에 아래 명령어를 통해 로컬 db 및 user 를 설정 해준다.

```shell
# 아래 명령어로 mysql container 에 접속
docker exec -it mysql-moon mysql -uroot -ptothemoon!
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
