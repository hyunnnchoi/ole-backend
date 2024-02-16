/*
 카테고리 테이블
 */
INSERT INTO category(name, created_at) VALUES('스마트폰', NOW()) ;
INSERT INTO category(name, created_at) VALUES('컴퓨터', NOW()) ;
INSERT INTO category(name, created_at) VALUES('키오스크', NOW()) ;
INSERT INTO category(name, created_at) VALUES('외국어', NOW()) ;
INSERT INTO category(name, created_at) VALUES('운동', NOW()) ;
INSERT INTO category(name, created_at) VALUES('공예', NOW()) ;
INSERT INTO category(name, created_at) VALUES('부동산', NOW()) ;
INSERT INTO category(name, created_at) VALUES('심리', NOW()) ;
INSERT INTO category(name, created_at) VALUES('취업/창업', NOW()) ;
INSERT INTO category(name, created_at) VALUES('요리', NOW()) ;
INSERT INTO category(name, created_at) VALUES('악기', NOW()) ;
INSERT INTO category(name, created_at) VALUES('자산', NOW()) ;

/*
 세부카테고리 테이블
 */
INSERT INTO sub_category( name, category_id, created_at) VALUES('기본 설정(앱 설치, 환경설정 등)', 1, '2024-01-01') ;
INSERT INTO sub_category( name, category_id, created_at) VALUES('기본 활용(카메라,갤러리 등)', 1, '2024-01-01') ;
INSERT INTO sub_category( name, category_id, created_at) VALUES('실생활 활용(카카오톡,모바일 주문, 배달 앱 등)', 1, '2024-01-01') ;
INSERT INTO sub_category( name, category_id, created_at) VALUES('컴퓨터 기초 활용', 2, '2024-01-01') ;
INSERT INTO sub_category( name, category_id, created_at) VALUES('키오스크 접해보기', 3, '2024-01-01') ;
INSERT INTO sub_category( name, category_id, created_at) VALUES('생활 영어', 4, '2024-01-01') ;
INSERT INTO sub_category( name, category_id, created_at) VALUES('건강 상식', 5, '2024-01-01') ;
INSERT INTO sub_category( name, category_id, created_at) VALUES('식물/동물', 6, '2024-01-01') ;
INSERT INTO sub_category( name, category_id, created_at) VALUES('기초 부동산 지식', 7, '2024-01-01') ;


-- 교육 테이블
INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, place, price, refund, supplies, title, sub_category_id, gather_status, price_status)
VALUES ('2024-02-01','APPROVED', 1, '카카오톡의 다양한 기능을 알아보는 과정(카메라,오픈채팅방,카카오T,카카오 선물하기 등)',
        '2024-02-20', '2024-02-01',
        'WEDNESDAY', '2024-03-29 16:00', '2024-03-29', '2024-02-28', '2024-02-28 14:00',
        'ONLINE', 16, '노원50플러스센터 3층 배움탐색실', 20000, '환불규정', '스마트폰', '카카오톡, 생활에 유용한 앱 활용', 3, TRUE, TRUE);

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, place, price,  supplies, title, sub_category_id, gather_status, price_status)
VALUES ( '2024-02-01', 'APPROVED', 1, '일반적 표현을 위한 주요 어휘 및 관련 문장 학습: 대중교통 이용, 여가와 오락,항공,금융,호텔,주거 등등 일상 생활에서 쓰이는 영어 학습',
        '2024-02-20', '2024-02-01',
        'MONDAY', '2024-05-03 12:00', '2024-05-03', '2024-04-08', '2024-04-08 10:00',
        'OFFLINE', 30, '동작50플러스센터 2층 미디어실', 15000, '필기구', 'YOU CAN SPEAK 일상표현 영어', 6, TRUE, TRUE);

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, place, price, supplies, title, sub_category_id, gather_status, price_status)
VALUES ('2024-02-10', 'APPROVED', 1, '내 손안에 들어온 작은 컴퓨터_스마트폰을 일상생활에 잘 활용하는 방법을 기초부터 천천히 알아보는 시간입니다.처음 시작하는 분 모이세요~',
        '2024-02-25', '2024-02-10',
        'WEDNESDAY', '2024-03-27 15:30', '2024-03-27', '2024-02-28', '2024-02-28 13:30',
        'OFFLINE', 15, '서대문50플러스센터 강의실 3', 0, '스마트폰, 개인 충전기', '생활 스마트폰-처음시작', 2, TRUE, FALSE);

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, place, price, supplies, title, sub_category_id, gather_status, price_status)
VALUES ('2024-02-24','APPROVED', 1,'스마트폰의 다양한 기능을 100% 활용하고 싶은 5060 세대를 위한 강좌. 디지털 기기 사용에 서툰 분들에게 차근차근 설명해드립니다.',
        '2024-03-01', '2024-02-24',
        'MONDAY', '2024-03-25','2024-03-25 16:00', '2024-03-11', '2024-03-11 14:00',
        'OFFLINE',15,'더하기홀',0,'스마트(안드로이드)', '디지털 왕초보를 위한 생활 속 스마트폰 활용 꿀팁!', 2, TRUE, FALSE);

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, price, title, sub_category_id, gather_status, price_status)
VALUES ('2024-01-21','APPROVED', 1,
        '2024-02-21', '2024-01-21',
        'SATURDAY', '2024-03-15','2024-03-15 12:00', '2024-02-24', '2024-02-24 10:00',
        'OFFLINE', 10,20000,'K강사가 알려주는 스마트한 디지털 활용(스마트폰 초급)', 1, TRUE, TRUE);

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, place, price, supplies, title, sub_category_id, gather_status, price_status)
VALUES ('2024-02-01','APPROVED', 1, '모바일 뱅킹 이용 학습, 금융인증서 발급, 계좌조회/기관 계좌이체/출금의 다양한 기능,오픈뱅킹,마이데이터,은행 거래 꿀팁 등 학습 및 실습',
        '2024-02-27', '2024-02-01',
        'TUESDAY', '2024-04-25','2024-04-25 12:00', '2024-03-12', '2024-03-12 10:00',
        'OFFLINE',20,'양천 다누리홀',5000,'스마트폰,신분증,OTP 또는 보안카드', '[시니어디지털금융교육]넌 은행가니? 난 스마트폰으로 한다!', 3, TRUE, TRUE);

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type,limit_count,  price, title, sub_category_id, gather_status, price_status)
VALUES ('2024-02-07','APPROVED', 1,
        '2024-03-02', '2024-02-07',
        'WEDNESDAY', '2024-03-20','2024-03-20 15:30', '2024-03-13', '2024-03-13 13:30',
        'ONLINE', 10,0,'스마트폰 내 손안의 컴퓨터', 1, TRUE, FALSE);

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count,price,title, sub_category_id, gather_status, price_status)
VALUES ('2024-02-11','APPROVED', 1,
        '2024-03-08', '2024-02-11',
        'FRIDAY', '2024-03-29','2024-03-29 12:00', '2024-03-15', '2024-03-15 10:00',
        'OFFLINE',10,0,'누구나 쉽게 배우는 스마트폰 영상 만들기(초급)', 3, TRUE, FALSE);

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type,limit_count, price, title, sub_category_id, gather_status, price_status)
VALUES ('2024-02-15','APPROVED', 1,
        '2024-03-10', '2024-02-15',
        'WEDNESDAY', '2024-04-03','2024-04-03 16:30', '2024-03-20', '2024-03-20 14:30',
        'OFFLINE', 10,5000,'스마트폰, 이것만 알아도!', 2, TRUE, TRUE);

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type,limit_count, price,title, sub_category_id, gather_status, price_status)
VALUES ('2024-02-19','APPROVED', 1,
        '2024-03-19', '2024-02-19',
        'MONDAY', '2024-04-02','2024-04-02 11:00', '2024-04-01', '2024-04-01 10:00',
        'ONLINE',10,8000, '스마트폰으로 구직정보 탐색하기', 3, TRUE, TRUE);

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, price, title, sub_category_id, gather_status, price_status)
VALUES ('2024-02-12','APPROVED', 1,
        '2024-03-25', '2024-02-12',
        'TUESDAY', '2024-04-09','2024-04-09 17:30', '2024-04-02', '2024-04-02 15:30',
        'ONLINE',10,6000, '누구나 쉽게 배우는 스마트폰 영상 만들기(중급)', 3, TRUE, TRUE);

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, price,title, sub_category_id, gather_status, price_status)
VALUES ('2024-01-30','APPROVED', 1,
        '2024-03-30', '2024-01-30',
        'THURSDAY', '2024-04-15','2024-04-15 16:00', '2024-04-04', '2024-04-04 13:00',
        'OFFLINE',10, 0,'스마트폰을 더 스마트하게! 유용한 앱(APP) 활용', 3, TRUE, FALSE);

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, price, title, sub_category_id, gather_status, price_status)
VALUES ('2024-02-15','APPROVED', 1,
        '2024-03-15', '2024-02-15',
        'SUNDAY', '2024-05-19','2024-05-15 17:00', '2024-04-14', '2024-04-14 13:00',
        'OFFLINE', 10,3000,'스마트폰 & Chat GPT 활용 중년 돈 공부', 3, TRUE, TRUE);

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, price, title, sub_category_id, gather_status, price_status)
VALUES ('2024-02-19','APPROVED', 1,
        '2024-04-01', '2024-02-19',
        'MONDAY', '2024-04-29','2024-04-29 12:00', '2024-04-22', '2024-04-22 09:00',
        'ONLINE', 10,2000,'소상공인을 위한 스마트폰 사용법', 2, TRUE, TRUE);

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, place, price, supplies, title, sub_category_id, gather_status, price_status)
VALUES ('2024-02-01','APPROVED', 1, '모바일 뱅킹 이용 학습, 금융인증서 발급, 계좌조회/기관 계좌이체/출금의 다양한 기능,오픈뱅킹,마이데이터,은행 거래 꿀팁 등 학습 및 실습',
        '2024-02-27', '2024-02-01',
        'TUESDAY', '2024-04-25','2024-04-25 12:00', '2024-03-12', '2024-03-12 10:00',
        'OFFLINE',20,'양천 다누리홀',5000,'스마트폰,신분증,OTP 또는 보안카드', '[시니어디지털금융교육]넌 은행가니? 난 스마트폰으로 한다!', 3, TRUE, TRUE);

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, place, price, supplies, title, sub_category_id, gather_status, price_status)
VALUES ('2024-01-20','APPROVED', 1, '컴퓨터 기초 과정으로, 컴퓨터와 주변 기기의 사용법을 학습하며, 컴퓨터와 스마트폰을 함께 활용하며 배우는 과정',
        '2024-02-20', '2024-01-20',
        'SATURDAY', '2024-04-27','2024-04-27 15:30', '2024-03-17', '2024-03-17 13:30',
        'OFFLINE',16,'노원 50 플러스센터 4층 미디어실',30000,'스마트폰(안드로이드),교재구입(개강날 안내)','누구나 쉽게 귀에 쏙쏘 컴퓨터 왕기초',4, TRUE, TRUE);

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, price, supplies, title, sub_category_id, gather_status, price_status)
VALUES ('2024-02-20','APPROVED', 1, '키오스크 사용이 불편하고 두려운 분, 키오스크 사용에 관심은 있지만, 접할 기회가 없었던 분!',
        '2024-04-05', '2024-02-20',
        'MONDAY', '2024-04-17','2024-04-11 16:00', '2024-04-11', '2024-04-11 14:00',
        'ONLINE',20,5000,'개인 카드','무인단말기(키오스트) 사용 실전 체험 과정',5, TRUE, TRUE);




-- 강사 테이블
INSERT INTO teacher(birth, gender, name) VALUES (1988, 'WOMAN', '서정희');
INSERT INTO teacher(birth, gender, name) VALUES (1973, 'MAN', '김진형');
INSERT INTO teacher(birth, gender, name) VALUES (1992, 'WOMAN', '정희정');
INSERT INTO teacher(birth, gender, name) VALUES (2001, 'MAN', '조현호');
INSERT INTO teacher(birth, gender, name) VALUES (1972, 'WOMAN', '전윤정');
INSERT INTO teacher(birth, gender, name) VALUES (2005, 'WOMAN', '손지연');
INSERT INTO teacher(birth, gender, name) VALUES (1985, 'MAN', '매지에코');


-- 교육-강사 테이블
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (1, 2);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (1, 1);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (2, 3);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (3, 2);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (4, 5);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (7, 6);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (17, 7);


INSERT INTO file(name, path, represent, lesson_id, member_id) VALUES ('test', 'resources/static/test.png', TRUE, 1, null);
INSERT INTO file(name, path, represent, lesson_id, member_id) VALUES ('test1-f', 'resources/static/test2.png', FALSE, 1, null);
INSERT INTO file(name, lesson_id, member_id) VALUES ('test2', 2, null);
INSERT INTO file(name, lesson_id, member_id) VALUES ('test3', 3, null);

INSERT IGNORE INTO member(id, created_at, updated_at, address, birth_year, email, gender, mail_agree, name, password, phone_num, refresh_token, role, sms_agree, social_id, social_type)
VALUES (1, '2024-01-26 23:50:17.000000', '2024-01-26 23:50:19.000000', '주소', 1999, 'ji@naver.com', 'MALE', true, '이륾', 'qwerty', '010-1234-4646', 'sdadfasdfasdf', 'USER', true, 'asd', 'KAKAO');
INSERT IGNORE INTO member(id, created_at, updated_at, address, birth_year, email, gender, mail_agree, name, password, phone_num, refresh_token, role, sms_agree, social_id, social_type)
VALUES (2, '2024-01-26 23:50:17.000000', '2024-01-26 23:50:19.000000', '주소', 1999, 'ji@naver.com', 'MALE', true, '이륾2', 'qwerty', '010-1234-4646', 'sdadfasdfasdf', 'USER', true, 'asd', 'KAKAO');
INSERT IGNORE INTO member(id, created_at, updated_at, address, birth_year, email, gender, mail_agree, name, password, phone_num, refresh_token, role, sms_agree, social_id, social_type)
VALUES (3, '2024-01-26 23:50:17.000000', '2024-01-26 23:50:19.000000', '주소', 1999, 'ji@naver.com', 'MALE', true, '이륾3', 'qwerty', '010-1234-4646', 'sdadfasdfasdf', 'USER', true, 'asd', 'KAKAO');

INSERT INTO community(created_at, body, category, title, member_id, views) VALUES (NOW(), '저처럼 요리 초보이신 남자분들 수업 같이 들으면 좋을 것 같아요. 링크는 여기 있습니다.', 'TOGETHER', '은평구 요리 교실 수업 같이 들어요', 1, 10);
INSERT INTO community(body, category, title, member_id, views) VALUES ('저는 음료수를 잘 안먹어서 환불하고 싶은데 좀 쉽게 설명해주실 분. 지금 편의점에 있어서 빨리', 'QUESTION', '기프티콘 환불하는 법 아시는 분?', 2, 122);
INSERT INTO community(body, category, title, member_id, views) VALUES ('기존 사진의 색상을 바꾸거나 위치 수정 또는 배경 변경하려고 하는데 포토샵에서 어떤 기능 써야 하나요?', 'QUESTION', '이거 포토샵으로 가능한건가요?', 3, 1233);

INSERT INTO community_comment(content, community_id, member_id) VALUES ("1번글 댓글",1, 2);
INSERT INTO community_comment(content, community_id, member_id) VALUES ("2번글 댓글",2, 3);
INSERT INTO community_comment(content, community_id, member_id) VALUES ("3번글 댓글",3, 1);

INSERT INTO news(created_at, category, author, content, title) VALUES ('2024-01-26 23:50:19.000000', 'BOARD', '친절한 쩡아쌤', '생활뉴스 글1', '생활뉴스 제목1');
INSERT INTO news(created_at, category, author, content, title) VALUES ('2024-01-27 23:50:19.000000', 'HEALTH', '친절한 쩡아쌤', '생활뉴스 글2', '생활뉴스 제목2');
INSERT INTO news(created_at, category, author, content, title) VALUES ('2024-01-25 23:50:19.000000','LIFE', '친절한 쩡아쌤', '생활뉴스 글3', '생활뉴스 제목3');
INSERT INTO news(created_at, category, author, content, title) VALUES ('2024-01-23 23:50:19.000000','RECRUIT', '친절한 쩡아쌤', '생활뉴스 글4', '생활뉴스 제목4');

INSERT INTO file(name, lesson_id, member_id, news_id) VALUES ('뉴스 테스트', null, null, 1);
INSERT INTO file(name, path, represent, lesson_id, member_id, news_id) VALUES ('test', 'resources/static/test.png', FALSE, null, null, 1);

INSERT INTO file(name, lesson_id, member_id, news_id) VALUES ('뉴스 테스트', null, null, 2);
INSERT INTO file(name, lesson_id, member_id, news_id) VALUES ('뉴스 테스트', null, null, 3);
INSERT INTO file(name, lesson_id, member_id, news_id) VALUES ('뉴스 테스트', null, null, 4);