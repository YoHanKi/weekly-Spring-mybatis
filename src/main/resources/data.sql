create table article (
                         id BIGINT AUTO_INCREMENT primary key,
                         title varchar(255) not null,
                         content varchar(255) not null,
                         created_at timestamp default now(),
                         updated_at timestamp default now()
);

INSERT INTO article (title, content) VALUES ('블로그 제목', '블로그 내용');
INSERT INTO article (title, content) VALUES ('블로그 제목2', '블로그 내용2');
INSERT INTO article (title, content) VALUES ('블로그 제목3', '블로그 내용3');

create table comment (
                         id BIGINT AUTO_INCREMENT primary key,
                         article_id BIGINT,
                         body varchar(255) not null,
                         created_at timestamp default now(),
                         FOREIGN KEY (article_id) REFERENCES article(id) ON DELETE CASCADE
);

INSERT INTO comment (article_id, body, created_at) VALUES (1,'댓글 내용1', now());
INSERT INTO comment (article_id, body, created_at) VALUES (1,'댓글 내용2', now());