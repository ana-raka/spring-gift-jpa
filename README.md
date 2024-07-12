# 🚀 2단계 - 연관 관계 매핑

- 기능 요구 사항
- 지금까지 작성한 JdbcTemplate 기반 코드를 JPA로 리팩터링하고 실제 도메인 모델을 어떻게 구성하고 객체와 테이블을 어떻게 매핑해야 하는지 알아본다.

- 객체의 참조와 테이블의 외래 키를 매핑해서 객체에서는 참조를 사용하고 테이블에서는 외래 키를 사용할 수 있도록 한다.

# 🚀 1단계 - 엔티티 매핑

## 과제 진행 요구 사항
- 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
- AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.

## 기능 요구 사항
- 지금까지 작성한 JdbcTemplate 기반 코드를 JPA로 리팩터링하고 실제 도메인 모델을 어떻게 구성하고 객체와 테이블을 어떻게 매핑해야 하는지 알아본다.

- 아래의 DDL(Data Definition Language)을 보고 유추하여 엔티티 클래스와 리포지토리 클래스를 작성해 본다.
- @DataJpaTest를 사용하여 학습 테스트를 해 본다.
<pre>
<code>
  create table member
    (
        id       bigint generated by default as identity,
        email    varchar(255) not null unique,
        password varchar(255) not null,
        primary key (id)
    )
</code>
</pre>
<pre>
<code>
    create table product
    (
        price     integer      not null,
        id        bigint generated by default as identity,
        name      varchar(15)  not null,
        image_url varchar(255) not null,
        primary key (id)
    )
</code>
</pre>
<pre>
<code>
    create table wish
    (
        id         bigint generated by default as identity,
        member_id  bigint not null,
        product_id bigint not null,
        primary key (id)
    )
</code>
</pre>
