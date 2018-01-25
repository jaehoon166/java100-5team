-- 베스트 코디네이터
DROP TABLE IF EXISTS best_contr RESTRICT;

-- 데일리 트랜드
DROP TABLE IF EXISTS trend RESTRICT;

-- 코디게시글
DROP TABLE IF EXISTS cody_board RESTRICT;

-- 취향분석
DROP TABLE IF EXISTS analysis RESTRICT;

-- 회원
DROP TABLE IF EXISTS member RESTRICT;

-- 공지사항
DROP TABLE IF EXISTS notice RESTRICT;

-- 질문게시판
DROP TABLE IF EXISTS q_board RESTRICT;

-- 친구
DROP TABLE IF EXISTS friend RESTRICT;

-- 코디게시판 댓글
DROP TABLE IF EXISTS cody_comment RESTRICT;

-- 베스트 코디게시판 댓글
DROP TABLE IF EXISTS best_board RESTRICT;

-- 좋아요
DROP TABLE IF EXISTS liked RESTRICT;

-- FAQ
DROP TABLE IF EXISTS faq RESTRICT;

-- 베스트 코디네이터
CREATE TABLE best_contr (
	bc_no INTEGER NOT NULL COMMENT '베스트 코디게시글번호', -- 베스트 코디게시글번호
	co_no INTEGER NOT NULL COMMENT '코디게시글번호', -- 코디게시글번호
	lank  INTEGER NULL     COMMENT '순위' -- 순위
)
COMMENT '베스트 코디네이터';

-- 베스트 코디네이터
ALTER TABLE best_contr
	ADD CONSTRAINT PK_best_contr -- 베스트 코디네이터 기본키
		PRIMARY KEY (
			bc_no -- 베스트 코디게시글번호
		);

ALTER TABLE best_contr
	MODIFY COLUMN bc_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '베스트 코디게시글번호';

-- 데일리 트랜드
CREATE TABLE trend (
	op_tag VARCHAR(50)  NULL COMMENT '운영자 추천 태그', -- 운영자 추천 태그
	photo  VARCHAR(255) NULL COMMENT '사진' -- 사진
)
COMMENT '데일리 트랜드';

-- 코디게시글
CREATE TABLE cody_board (
	co_no    INTEGER      NOT NULL COMMENT '코디게시글번호', -- 코디게시글번호
	title    VARCHAR(20)  NULL     COMMENT '제목', -- 제목
	conts    VARCHAR(255) NULL     COMMENT '내용', -- 내용
	m_no     INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	datetime DATE         NULL     COMMENT '날짜', -- 날짜
	co_photo VARCHAR(255) NULL     COMMENT '사진', -- 사진
	gender   VARCHAR(5)   NULL     COMMENT '성별', -- 성별
	views    INTEGER      NULL     COMMENT '조회수', -- 조회수
	h_tag    VARCHAR(50)  NULL     COMMENT '해시태그' -- 해시태그
)
COMMENT '코디게시글';

-- 코디게시글
ALTER TABLE cody_board
	ADD CONSTRAINT PK_cody_board -- 코디게시글 기본키
		PRIMARY KEY (
			co_no -- 코디게시글번호
		);

ALTER TABLE cody_board
	MODIFY COLUMN co_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '코디게시글번호';

-- 취향분석
CREATE TABLE analysis (
	ana_no INTEGER     NOT NULL COMMENT '분석번호', -- 분석번호
	m_no   INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
	h_tag  VARCHAR(50) NULL     COMMENT '해시태그' -- 해시태그
)
COMMENT '취향분석';

-- 취향분석
ALTER TABLE analysis
	ADD CONSTRAINT PK_analysis -- 취향분석 기본키
		PRIMARY KEY (
			ana_no -- 분석번호
		);

ALTER TABLE analysis
	MODIFY COLUMN ana_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '분석번호';

-- 회원
CREATE TABLE member (
	m_no    INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	m_photo VARCHAR(255) NULL     COMMENT '사진', -- 사진
	name    VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	email   VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	id      VARCHAR(20)  NOT NULL COMMENT '아이디', -- 아이디
	pwd     VARCHAR(100) NOT NULL COMMENT '비밀번호', -- 비밀번호
	age     INTEGER      NOT NULL COMMENT '나이', -- 나이
	gender  VARCHAR(5)   NOT NULL COMMENT '성별', -- 성별
	phone   VARCHAR(30)  NOT NULL COMMENT '전화번호', -- 전화번호
	intro   TEXT         NULL     COMMENT '소개글', -- 소개글
	level   INTEGER      NOT NULL COMMENT '권한레벨', -- 권한레벨
	top     INTEGER      NULL     COMMENT '상의', -- 상의
	pants   INTEGER      NULL     COMMENT '하의' -- 하의
)
COMMENT '회원';

-- 회원
ALTER TABLE member
	ADD CONSTRAINT PK_member -- 회원 기본키
		PRIMARY KEY (
			m_no -- 회원번호
		);

-- 회원 아이디
CREATE UNIQUE INDEX UIX_member
	ON member ( -- 회원
		id ASC -- 아이디
	);

-- 회원 이메일
CREATE UNIQUE INDEX UIX_member2
	ON member ( -- 회원
		email ASC -- 이메일
	);

ALTER TABLE member
	MODIFY COLUMN m_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 공지사항
CREATE TABLE notice (
	n_no  INTEGER      NOT NULL COMMENT '공지사항번호', -- 공지사항번호
	title VARCHAR(20)  NOT NULL COMMENT '제목', -- 제목
	conts VARCHAR(255) NOT NULL COMMENT '내용', -- 내용
	date  DATE         NULL     COMMENT '날짜' -- 날짜
)
COMMENT '공지사항';

-- 공지사항
ALTER TABLE notice
	ADD CONSTRAINT PK_notice -- 공지사항 기본키
		PRIMARY KEY (
			n_no -- 공지사항번호
		);

ALTER TABLE notice
	MODIFY COLUMN n_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '공지사항번호';

-- 질문게시판
CREATE TABLE q_board (
	q_no     INTEGER      NOT NULL COMMENT '질문번호', -- 질문번호
	m_no     INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	title    VARCHAR(20)  NULL     COMMENT '제목', -- 제목
	conts    VARCHAR(255) NULL     COMMENT '내용', -- 내용
	datetime DATE         NULL     COMMENT '날짜', -- 날짜
	comment  TEXT         NULL     COMMENT '답변', -- 답변
	views    INTEGER      NULL     COMMENT '조회수' -- 조회수
)
COMMENT '질문게시판';

-- 질문게시판
ALTER TABLE q_board
	ADD CONSTRAINT PK_q_board -- 질문게시판 기본키
		PRIMARY KEY (
			q_no -- 질문번호
		);

ALTER TABLE q_board
	MODIFY COLUMN q_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '질문번호';

-- 친구
CREATE TABLE friend (
	m_no  INTEGER NOT NULL COMMENT '팔로워', -- 팔로워
	m_no2 INTEGER NOT NULL COMMENT '팔로잉' -- 팔로잉
)
COMMENT '친구';

-- 친구
ALTER TABLE friend
	ADD CONSTRAINT PK_friend -- 친구 기본키
		PRIMARY KEY (
			m_no,  -- 팔로워
			m_no2  -- 팔로잉
		);

-- 코디게시판 댓글
CREATE TABLE cody_comment (
	com_no INTEGER      NOT NULL COMMENT '댓글번호', -- 댓글번호
	m_no   INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	co_no  INTEGER      NOT NULL COMMENT '코디게시글번호', -- 코디게시글번호
	conts  VARCHAR(255) NULL     COMMENT '내용', -- 내용
	date   DATE         NULL     COMMENT '날짜' -- 날짜
)
COMMENT '코디게시판 댓글';

-- 코디게시판 댓글
ALTER TABLE cody_comment
	ADD CONSTRAINT PK_cody_comment -- 코디게시판 댓글 기본키
		PRIMARY KEY (
			com_no -- 댓글번호
		);

ALTER TABLE cody_comment
	MODIFY COLUMN com_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '댓글번호';

-- 베스트 코디게시판 댓글
CREATE TABLE best_board (
	bb_no INTEGER      NOT NULL COMMENT '댓글번호', -- 댓글번호
	bc_no INTEGER      NOT NULL COMMENT '베스트 코디게시글번호', -- 베스트 코디게시글번호
	m_no  INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	conts VARCHAR(255) NULL     COMMENT '내용', -- 내용
	date  DATE         NULL     COMMENT '날짜' -- 날짜
)
COMMENT '베스트 코디게시판 댓글';

-- 베스트 코디게시판 댓글
ALTER TABLE best_board
	ADD CONSTRAINT PK_best_board -- 베스트 코디게시판 댓글 기본키
		PRIMARY KEY (
			bb_no -- 댓글번호
		);

ALTER TABLE best_board
	MODIFY COLUMN bb_no INTEGER NOT NULL AUTO_INCREMENT COMMENT '댓글번호';

-- 좋아요
CREATE TABLE liked (
	m_no  INTEGER NOT NULL COMMENT '회원번호', -- 회원번호
	co_no INTEGER NOT NULL COMMENT '코디게시글번호' -- 코디게시글번호
)
COMMENT '좋아요';

-- 좋아요
ALTER TABLE liked
	ADD CONSTRAINT PK_liked -- 좋아요 기본키
		PRIMARY KEY (
			m_no,  -- 회원번호
			co_no  -- 코디게시글번호
		);

-- FAQ
CREATE TABLE faq (
	faq_no  INTEGER      NOT NULL COMMENT 'FAQ번호', -- FAQ번호
	title   VARCHAR(20)  NULL     COMMENT '제목', -- 제목
	conts   VARCHAR(255) NULL     COMMENT '내용', -- 내용
	date    DATE         NULL     COMMENT '날짜', -- 날짜
	comment TEXT         NULL     COMMENT '답변', -- 답변
	views   INTEGER      NULL     COMMENT '조회수' -- 조회수
)
COMMENT 'FAQ';

-- FAQ
ALTER TABLE faq
	ADD CONSTRAINT PK_faq -- FAQ 기본키
		PRIMARY KEY (
			faq_no -- FAQ번호
		);

ALTER TABLE faq
	MODIFY COLUMN faq_no INTEGER NOT NULL AUTO_INCREMENT COMMENT 'FAQ번호';

-- 베스트 코디네이터
ALTER TABLE best_contr
	ADD CONSTRAINT FK_cody_board_TO_best_contr -- 코디게시글 -> 베스트 코디네이터
		FOREIGN KEY (
			co_no -- 코디게시글번호
		)
		REFERENCES cody_board ( -- 코디게시글
			co_no -- 코디게시글번호
		);

-- 코디게시글
ALTER TABLE cody_board
	ADD CONSTRAINT FK_member_TO_cody_board -- 회원 -> 코디게시글
		FOREIGN KEY (
			m_no -- 회원번호
		)
		REFERENCES member ( -- 회원
			m_no -- 회원번호
		);

-- 취향분석
ALTER TABLE analysis
	ADD CONSTRAINT FK_member_TO_analysis -- 회원 -> 취향분석
		FOREIGN KEY (
			m_no -- 회원번호
		)
		REFERENCES member ( -- 회원
			m_no -- 회원번호
		);

-- 질문게시판
ALTER TABLE q_board
	ADD CONSTRAINT FK_member_TO_q_board -- 회원 -> 질문게시판
		FOREIGN KEY (
			m_no -- 회원번호
		)
		REFERENCES member ( -- 회원
			m_no -- 회원번호
		);

-- 친구
ALTER TABLE friend
	ADD CONSTRAINT FK_member_TO_friend -- 회원 -> 친구
		FOREIGN KEY (
			m_no -- 팔로워
		)
		REFERENCES member ( -- 회원
			m_no -- 회원번호
		);

-- 친구
ALTER TABLE friend
	ADD CONSTRAINT FK_member_TO_friend2 -- 회원 -> 친구2
		FOREIGN KEY (
			m_no2 -- 팔로잉
		)
		REFERENCES member ( -- 회원
			m_no -- 회원번호
		);

-- 코디게시판 댓글
ALTER TABLE cody_comment
	ADD CONSTRAINT FK_member_TO_cody_comment -- 회원 -> 코디게시판 댓글
		FOREIGN KEY (
			m_no -- 회원번호
		)
		REFERENCES member ( -- 회원
			m_no -- 회원번호
		);

-- 코디게시판 댓글
ALTER TABLE cody_comment
	ADD CONSTRAINT FK_cody_board_TO_cody_comment -- 코디게시글 -> 코디게시판 댓글
		FOREIGN KEY (
			co_no -- 코디게시글번호
		)
		REFERENCES cody_board ( -- 코디게시글
			co_no -- 코디게시글번호
		);

-- 베스트 코디게시판 댓글
ALTER TABLE best_board
	ADD CONSTRAINT FK_member_TO_best_board -- 회원 -> 베스트 코디게시판 댓글
		FOREIGN KEY (
			m_no -- 회원번호
		)
		REFERENCES member ( -- 회원
			m_no -- 회원번호
		);

-- 베스트 코디게시판 댓글
ALTER TABLE best_board
	ADD CONSTRAINT FK_best_contr_TO_best_board -- 베스트 코디네이터 -> 베스트 코디게시판 댓글
		FOREIGN KEY (
			bc_no -- 베스트 코디게시글번호
		)
		REFERENCES best_contr ( -- 베스트 코디네이터
			bc_no -- 베스트 코디게시글번호
		);

-- 좋아요
ALTER TABLE liked
	ADD CONSTRAINT FK_member_TO_liked -- 회원 -> 좋아요
		FOREIGN KEY (
			m_no -- 회원번호
		)
		REFERENCES member ( -- 회원
			m_no -- 회원번호
		);

-- 좋아요
ALTER TABLE liked
	ADD CONSTRAINT FK_cody_board_TO_liked -- 코디게시글 -> 좋아요
		FOREIGN KEY (
			co_no -- 코디게시글번호
		)
		REFERENCES cody_board ( -- 코디게시글
			co_no -- 코디게시글번호
		);