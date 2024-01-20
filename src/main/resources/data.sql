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

-- 교육 테이블
INSERT INTO LESSON(approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, place, price, refund, supplies, title, views, subcategory_id)
VALUES ('APPROVED', 1, '카카오톡의 다양한 기능을 알아보는 과정',
        NOW(), NOW(),
        'MONDAY', NOW(), NOW(), NOW(), NOW(),
        'ONLINE', 30, '노원50플러스센터', 20000, '환불규정', '스마트폰', '카카오톡, 생활에 유용한 앱 활용', 3, 1);

INSERT INTO LESSON(approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, place, price, refund, supplies, title, views, subcategory_id)
VALUES ('REVIEWING', 1, '일반적 표현을 위한 주요 어휘 및 관련 문장 학습',
        NOW(), NOW(),
        'FRIDAY', NOW(), NOW(), NOW(), NOW(),
        'ONLINE', 30, '동작50플러스센터', 15000, '환불규정', '필기구', 'YOU CAN SPEAK 일상표현 영어', 3, 4);

INSERT INTO LESSON(approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, place, price, refund, supplies, title, views, subcategory_id)
VALUES ('APPROVED', 1, '내 손안에 들어온 작은 컴퓨터_스마트폰을 일상생활에 잘 활용하는 방법',
        NOW(), NOW(),
        'TUESDAY', NOW(), NOW(), NOW(), NOW(),
        'OFFLINE', 30, '서대문50플러스센터', 0, '환불규정', '스마트폰, 개인 충전기', '생활 스마트폰-처음시작', 3, 1);

-- 강사 테이블
INSERT INTO TEACHER(birth, gender, name) VALUES (19881212, 'WOMAN', '서정희');
INSERT INTO TEACHER(birth, gender, name) VALUES (19730811, 'MAN', '김진형');

INSERT INTO TEACHER(birth, gender, name) VALUES (19920303, 'WOMAN', '정희정');
INSERT INTO TEACHER(birth, gender, name) VALUES (20010310, 'MAN', '조현호');

-- 교육-강사 테이블
INSERT INTO LECTURE_TEACHER(lesson_id, teacher_id) VALUES (1, 2);
INSERT INTO LECTURE_TEACHER(lesson_id, teacher_id) VALUES (1, 1);
INSERT INTO LECTURE_TEACHER(lesson_id, teacher_id) VALUES (2, 3);
INSERT INTO LECTURE_TEACHER(lesson_id, teacher_id) VALUES (3, 2);
