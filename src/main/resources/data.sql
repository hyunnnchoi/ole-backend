/*
 카테고리 테이블
 */
INSERT INTO CATEGORY(name, created_at) VALUES('스마트폰', NOW()) ;
INSERT INTO CATEGORY(name, created_at) VALUES('컴퓨터', NOW()) ;
INSERT INTO CATEGORY(name, created_at) VALUES('키오스크', NOW()) ;
INSERT INTO CATEGORY(name, created_at) VALUES('외국어', NOW()) ;
INSERT INTO CATEGORY(name, created_at) VALUES('운동', NOW()) ;
INSERT INTO CATEGORY(name, created_at) VALUES('공예', NOW()) ;
INSERT INTO CATEGORY(name, created_at) VALUES('부동산', NOW()) ;
INSERT INTO CATEGORY(name, created_at) VALUES('심리', NOW()) ;
INSERT INTO CATEGORY(name, created_at) VALUES('취업/창업', NOW()) ;
INSERT INTO CATEGORY(name, created_at) VALUES('요리', NOW()) ;
INSERT INTO CATEGORY(name, created_at) VALUES('악기', NOW()) ;
INSERT INTO CATEGORY(name, created_at) VALUES('자산', NOW()) ;

/*
 세부카테고리 테이블
 */
INSERT INTO SUB_CATEGORY( name, category_id, created_at) VALUES('기본 설정(앱 설치, 환경설정 등)', 1, NOW()) ;
INSERT INTO SUB_CATEGORY( name, category_id, created_at) VALUES('기본 활용(카메라,갤러리 등)', 1, NOW()) ;
INSERT INTO SUB_CATEGORY( name, category_id, created_at) VALUES('실생활 활용(카카오톡,모바일 주문, 배달 앱 등)', 1, NOW()) ;