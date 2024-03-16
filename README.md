# 🍟weekly-Spring-mybatis
위클리 스프링 부트 과제

### 과제 (article 테이블과 comment 테이블 관계)

<img src="https://github.com/YoHanKi/weekly-Spring-mybatis/assets/139758405/6b82c4ef-41b5-4299-9382-0c7006587446" width="500">

<img src="https://github.com/YoHanKi/weekly-Spring-mybatis/assets/139758405/e55ef638-3b4a-4cdc-bd80-0c95938afcad" width="500">

- comment의 FK를 사용하여 article(id)를 참조, 게시물이 삭제될 시 댓글도 삭제 될 수 있게, CASCADE 옵션을 추가

### GET /comments/{articleId} : 하나의 게시글의 댓글(리스트) 조회

![image](https://github.com/YoHanKi/weekly-Spring-mybatis/assets/139758405/9dc9ed74-03bb-46ff-8d26-6ebbe74da034)

- GET /comments/{articleId} 요청 시 사진과 같은 응답 출력

