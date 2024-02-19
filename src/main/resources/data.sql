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
INSERT INTO sub_category( name, category_id, created_at) VALUES('부동산/임대차', 7, '2024-01-01') ;
INSERT INTO sub_category( name, category_id, created_at) VALUES('재테크/재무관리', 7, '2024-01-01') ;
INSERT INTO sub_category( name, category_id, created_at) VALUES('공인중개사 준비', 7, '2024-01-01') ;
INSERT INTO sub_category( name, category_id, created_at) VALUES('기타', 7, '2024-01-01') ;


-- 교육 테이블
INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, place, price, refund, supplies, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-01','APPROVED', 10, '카카오톡의 다양한 기능을 알아보는 과정(카메라,오픈채팅방,카카오T,카카오 선물하기 등)',
        '2024-02-20', '2024-02-01',
        'WEDNESDAY', '2024-03-29 16:00', '2024-03-29', '2024-02-28', '2024-02-28 14:00',
        'ONLINE', 16, '노원50플러스센터 3층 배움탐색실', 20000, '환불규정', '스마트폰', '카카오톡, 생활에 유용한 앱 활용', 3, TRUE, TRUE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone1.png');

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, place, price,  supplies, title, sub_category_id, gather_status, price_status, image_url)
VALUES ( '2024-02-01', 'APPROVED', 20, '일반적 표현을 위한 주요 어휘 및 관련 문장 학습: 대중교통 이용, 여가와 오락,항공,금융,호텔,주거 등등 일상 생활에서 쓰이는 영어 학습',
        '2024-02-20', '2024-02-01',
        'MONDAY', '2024-05-03 12:00', '2024-05-03', '2024-04-08', '2024-04-08 10:00',
        'OFFLINE', 30, '동작50플러스센터 2층 미디어실', 15000, '필기구', 'YOU CAN SPEAK 일상표현 영어', 6, TRUE, TRUE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone5.png');

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, place, price, supplies, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-10', 'APPROVED', 11, '내 손안에 들어온 작은 컴퓨터_스마트폰을 일상생활에 잘 활용하는 방법을 기초부터 천천히 알아보는 시간입니다.처음 시작하는 분 모이세요~',
        '2024-02-25', '2024-02-10',
        'WEDNESDAY', '2024-03-27 15:30', '2024-03-27', '2024-02-28', '2024-02-28 13:30',
        'OFFLINE', 15, '서대문50플러스센터 강의실 3', 0, '스마트폰, 개인 충전기', '생활 스마트폰-처음시작', 2, TRUE, FALSE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone10.png');

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, place, price, supplies, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-24','APPROVED', 12,'스마트폰의 다양한 기능을 100% 활용하고 싶은 5060 세대를 위한 강좌. 디지털 기기 사용에 서툰 분들에게 차근차근 설명해드립니다.',
        '2024-03-01', '2024-02-24',
        'MONDAY', '2024-03-25','2024-03-25 16:00', '2024-03-11', '2024-03-11 14:00',
        'OFFLINE',15,'더하기홀',0,'스마트폰(안드로이드)', '디지털 왕초보를 위한 생활 속 스마트폰 활용 꿀팁!', 2, TRUE, FALSE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone11.png');

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type,limit_count, place , supplies, price, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-01-21','APPROVED', 7,
        '2024-02-21', '2024-01-21',
        'SATURDAY', '2024-03-15','2024-03-15 12:00', '2024-02-24', '2024-02-24 10:00',
        'OFFLINE', 10,'성남시 중앙도서관(2체험실)','없음',20000,'K강사가 알려주는 스마트한 디지털 활용(스마트폰 초급)', 1, TRUE, TRUE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone12.png');

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count,place, price, supplies, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-01','APPROVED', 6, '모바일 뱅킹 이용 학습, 금융인증서 발급, 계좌조회/기관 계좌이체/출금의 다양한 기능,오픈뱅킹,마이데이터,은행 거래 꿀팁 등 학습 및 실습',
        '2024-02-27', '2024-02-01',
        'TUESDAY', '2024-04-25','2024-04-25 12:00', '2024-03-12', '2024-03-12 10:00',
        'OFFLINE',20,'양천 다누리홀',5000,'스마트폰,신분증,OTP 또는 보안카드', '[시니어디지털금융교육]넌 은행가니? 난 스마트폰으로 한다!', 3, TRUE, TRUE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone13.png');

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type,limit_count, supplies,  price, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-07','APPROVED', 3,
        '2024-03-02', '2024-02-07',
        'WEDNESDAY', '2024-03-20','2024-03-20 15:30', '2024-03-13', '2024-03-13 13:30',
        'ONLINE', 10,'스마트폰',0,'스마트폰 내 손안의 컴퓨터', 1, TRUE, FALSE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone8.png');

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count,supplies,price,title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-11','APPROVED', 8,
        '2024-03-08', '2024-02-11',
        'FRIDAY', '2024-03-29','2024-03-29 12:00', '2024-03-15', '2024-03-15 10:00',
        'OFFLINE',10,'스마트폰',0,'누구나 쉽게 배우는 스마트폰 영상 만들기(초급)', 3, TRUE, FALSE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone7.png');

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type,limit_count, supplies,price, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-15','APPROVED', 5,
        '2024-03-10', '2024-02-15',
        'WEDNESDAY', '2024-04-03','2024-04-03 16:30', '2024-03-20', '2024-03-20 14:30',
        'OFFLINE', 10,'스마트폰',5000,'스마트폰, 이것만 알아도!', 2, TRUE, TRUE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone6.png');

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type,limit_count, price,supplies,title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-19','APPROVED', 9,
        '2024-03-19', '2024-02-19',
        'MONDAY', '2024-04-02','2024-04-02 11:00', '2024-04-01', '2024-04-01 10:00',
        'ONLINE',10,8000, '스마트폰','스마트폰으로 구직정보 탐색하기', 3, TRUE, TRUE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone5.png');

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, price, supplies, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-12','APPROVED', 2,
        '2024-03-25', '2024-02-12',
        'TUESDAY', '2024-04-09','2024-04-09 17:30', '2024-04-02', '2024-04-02 15:30',
        'ONLINE',10,6000,'스마트폰', '누구나 쉽게 배우는 스마트폰 영상 만들기(중급)', 3, TRUE, TRUE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone4.png');

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, price,supplies, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-01-30','APPROVED', 0,
        '2024-03-30', '2024-01-30',
        'THURSDAY', '2024-04-15','2024-04-15 16:00', '2024-04-04', '2024-04-04 13:00',
        'OFFLINE',10, 0,'스마트폰','스마트폰을 더 스마트하게! 유용한 앱(APP) 활용', 3, TRUE, FALSE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone3.png');

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, price,supplies, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-15','APPROVED', 15,
        '2024-03-15', '2024-02-15',
        'SUNDAY', '2024-05-19','2024-05-15 17:00', '2024-04-14', '2024-04-14 13:00',
        'OFFLINE', 20,3000,'없음','Chat GPT 활용', 3, TRUE, TRUE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone1.png');

INSERT INTO lesson(created_at, approved, current_count,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, price,supplies, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-19','APPROVED', 11,
        '2024-04-01', '2024-02-19',
        'MONDAY', '2024-04-29','2024-04-29 12:00', '2024-04-22', '2024-04-22 09:00',
        'ONLINE', 12,2000,'스마트폰','소상공인을 위한 스마트폰 사용법', 2, TRUE, TRUE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone11.png');

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, place, price, supplies, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-01','APPROVED', 20, '모바일 뱅킹 이용 학습, 금융인증서 발급, 계좌조회/기관 계좌이체/출금의 다양한 기능,오픈뱅킹,마이데이터,은행 거래 꿀팁 등 학습 및 실습',
        '2024-02-27', '2024-02-01',
        'TUESDAY', '2024-04-25','2024-04-25 12:00', '2024-03-12', '2024-03-12 10:00',
        'OFFLINE',25,'양천 다누리홀',5000,'스마트폰,신분증,OTP 또는 보안카드', '[시니어디지털금융교육]넌 은행가니? 난 스마트폰으로 한다!', 3, TRUE, TRUE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone9.png');

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, place, price, supplies, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-01-20','APPROVED', 14, '컴퓨터 기초 과정으로, 컴퓨터와 주변 기기의 사용법을 학습하며, 컴퓨터와 스마트폰을 함께 활용하며 배우는 과정',
        '2024-02-20', '2024-01-20',
        'SATURDAY', '2024-04-27','2024-04-27 15:30', '2024-03-17', '2024-03-17 13:30',
        'OFFLINE',16,'노원 50 플러스센터 4층 미디어실',30000,'스마트폰(안드로이드),교재구입(개강날 안내)','누구나 쉽게 귀에 쏙쏘 컴퓨터 왕기초',4, TRUE, TRUE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone13.png');

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, price, supplies, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-20','APPROVED', 19, '키오스크 사용이 불편하고 두려운 분, 키오스크 사용에 관심은 있지만, 접할 기회가 없었던 분!',
        '2024-04-05', '2024-02-20',
        'MONDAY', '2024-04-17','2024-04-11 16:00', '2024-04-11', '2024-04-11 14:00',
        'ONLINE',20,5000,'개인 카드','무인단말기(키오스트) 사용 실전 체험 과정',5, TRUE, TRUE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/smartphone4.png');

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, price, supplies, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-03','APPROVED', 11, '부동산 투자의 첫걸음! 재미있고 쉽게 배우는 쏙쏙 부동산 상식',
        '2024-02-25', '2024-02-03',
        'MONDAY', '2024-03-25','2024-02-26 16:00', '2024-02-26', '2024-04-11 14:00',
        'ONLINE',20,5000,'필기 도구','재미있고 유익한 부동산 상식',9, TRUE, TRUE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/lesson/property1.png');

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type, limit_count, price, supplies, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-01','APPROVED', 13, '전문가에게 제대로 배우는 법률 첫걸음',
        '2024-02-25', '2024-02-01',
        'FRIDAY', '2024-03-29','2024-03-29 17:00', '2024-02-29', '2024-02-29 13:00',
        'ONLINE',20,10000,'필기 도구','대한법률구조공단과 함께하는 생활법률',11, TRUE, TRUE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/lesson/property2.png');

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type,place ,limit_count, price, supplies, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-10','APPROVED', 11, '간단 투자를 통해 편안하고 풍족한 노후생활 준비',
        '2024-02-28', '2024-02-10',
        'MONDAY', '2024-04-11','2024-04-11 17:00', '2024-03-19', '2024-03-19 14:00',
        'OFFLINE','서울시',15,0,'필기 도구','부동산 재태크를 통한 똑똑한 노후준비 2기',10, TRUE, TRUE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/lesson/property3.png');

INSERT INTO lesson(created_at, approved, current_count, description,
                   gather_end_date, gather_start_date,
                   lecture_week_day, lesson_end_date, lesson_end_time, lesson_start_date, lesson_start_time,
                   lesson_type,place ,limit_count, price, supplies, title, sub_category_id, gather_status, price_status, image_url)
VALUES ('2024-02-10','APPROVED', 4, '답답하고 어려웠던 부동산에 대해 어떤 것이든 물어보세요! 10년 경력 전문가가 명쾌하게 답변해드립니다!',
        '2024-03-10', '2024-02-10',
        'THURSDAY', '2024-04-11','2024-04-11 17:00', '2024-04-11', '2024-04-11 14:00',
        'OFFLINE','서울시',15,20000,'필기 도구','무엇이든 물어보세요:부동산편',9, TRUE, TRUE, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/lesson/property4.png');




-- 강사 테이블
INSERT INTO teacher(birth, gender, name) VALUES (1988, 'WOMAN', '서정희');
INSERT INTO teacher(birth, gender, name) VALUES (1973, 'MAN', '김진형');
INSERT INTO teacher(birth, gender, name) VALUES (1992, 'WOMAN', '정희정');
INSERT INTO teacher(birth, gender, name) VALUES (2001, 'MAN', '조현호');
INSERT INTO teacher(birth, gender, name) VALUES (1972, 'WOMAN', '전윤정');
INSERT INTO teacher(birth, gender, name) VALUES (2005, 'WOMAN', '손지연');
INSERT INTO teacher(birth, gender, name) VALUES (1950, 'MAN', '매지에코');
INSERT INTO teacher(birth, gender, name) VALUES (1980, 'WOMAN', '이지연');
INSERT INTO teacher(birth, gender, name) VALUES (2004, 'MAN', '최진형');
INSERT INTO teacher(birth, gender, name) VALUES (2000, 'WOMAN', '김하늘');
INSERT INTO teacher(birth, gender, name) VALUES (1998, 'MAN', '박민수');
INSERT INTO teacher(birth, gender, name) VALUES (2001, 'MAN', '박진수');
INSERT INTO teacher(birth, gender, name) VALUES (2001, 'MAN', '이민형');
INSERT INTO teacher(birth, gender, name) VALUES (1985, 'WOMAN', '김지수');
INSERT INTO teacher(birth, gender, name) VALUES (1996, 'MAN', '이상혁');




-- 교육-강사 테이블
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (1, 2);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (1, 1);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (2, 3);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (3, 2);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (4, 5);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (5, 8);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (6, 9);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (7, 6);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (8, 10);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (9, 3);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (10, 4);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (11, 15);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (12, 6);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (13, 7);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (14, 8);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (15, 9);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (16, 15);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (17, 10);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (18, 11);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (19, 12);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (20, 13);
INSERT INTO lecture_teacher(lesson_id, teacher_id) VALUES (21, 14);


INSERT INTO file(name, path, represent, lesson_id, member_id) VALUES ('test', 'resources/static/test.png', TRUE, 1, null);
INSERT INTO file(name, path, represent, lesson_id, member_id) VALUES ('test1-f', 'resources/static/test2.png', FALSE, 1, null);
INSERT INTO file(name, lesson_id, member_id) VALUES ('test2', 2, null);
INSERT INTO file(name, lesson_id, member_id) VALUES ('test3', 3, null);

INSERT IGNORE INTO member(id, created_at, updated_at, address, birth_year, email, gender, mail_agree, name, password, phone_num, refresh_token, role, sms_agree, social_id, social_type)
VALUES (1, '2024-01-26 23:50:17.000000', '2024-01-26 23:50:19.000000', '주소', 1999, 'ole@ole.com', 'MALE', true, '올래회원', '{bcrypt}$2a$10$JlDiqaE0QjE9FPr7T6SoBuAEkUtSUKJsiNFtTQqspZWrvXOsxQpT2', '010-1234-4646', 'sdadfasdfasdf', 'USER', true, 'asd', 'KAKAO');
INSERT IGNORE INTO member(id, created_at, updated_at, address, birth_year, email, gender, mail_agree, name, password, phone_num, refresh_token, role, sms_agree, social_id, social_type)
VALUES (2, '2024-01-26 23:50:17.000000', '2024-01-26 23:50:19.000000', '주소', 1999, 'ji@naver.com', 'MALE', true, '이륾2', 'qwerty', '010-1234-4646', 'sdadfasdfasdf', 'USER', true, 'asd', 'KAKAO');
INSERT IGNORE INTO member(id, created_at, updated_at, address, birth_year, email, gender, mail_agree, name, password, phone_num, refresh_token, role, sms_agree, social_id, social_type)
VALUES (3, '2024-01-26 23:50:17.000000', '2024-01-26 23:50:19.000000', '주소', 1999, 'ji@naver.com', 'MALE', true, '이륾3', 'qwerty', '010-1234-4646', 'sdadfasdfasdf', 'USER', true, 'asd', 'KAKAO');

INSERT INTO community(created_at, body, category, title, member_id, views)
VALUES ('2024-02-20 12:50:19.000000', '저는 음료수를 잘 안먹어서 환불하고 싶은데 좀 쉽게 설명해주실 분 있나요? 며칠 전에 친구가 카카오톡으로 스타벅스 기프티콘을 보내줬어요. 안먹는거면 환불 된다는데 방법을 모르겠네요... ', 'QUESTION', '기프티콘 환불하는 법 아시는 분?', 1, 30490);
INSERT INTO community(created_at, body, category, title, member_id, views)
VALUES ('2024-02-20 11:50:19.000000', '저처럼 요리 초보이신 남자분들 수업 같이 들으면 좋을 것 같아요. 링크는 여기 있습니다. ', 'TOGETHER', '은평구 요리 교실 수업 같이 들어요', 1, 1923);
INSERT INTO community(created_at, body, category, title, member_id, views)
VALUES ('2024-02-19 21:50:19.000000', '기존 사진의 색상을 바꾸거나 위치 수정 또는 배경 변경하려고 하는데 포토샵에서 어떤 기능 써야 하나요?', 'QUESTION', '이거 포토샵으로 가능한건가요?', 1, 1329);
INSERT INTO community(created_at, body, category, title, member_id, views)
VALUES ('2024-02-19 20:50:19.000000', '갓수저로 살아가기, 주요 내용 : 1) 빌 게이츠, 스티브 잡스, 스티븐 스필버그 등 세계를 주름잡는 위인 사례 소개 2) 교육적 및 정서적 차원에서 분석한 그들의 성공 비결 ', 'TOGETHER', '특강 같이 가실 분', 1, 521);
INSERT INTO community(created_at, body, category, title, member_id, views)
VALUES ('2024-02-19 21:28:19.000000', '저희 동네에 고려대 경영대 나오신 20대 중국인 원어민 선생님이 있는데, 엄청 잘 가르친다고 하네요. 말하기 수업 1시간에 15000원이고, 전화 수업도 하신다고 하는', 'TOGETHER', '중국어 교육 같이 들어요', 1, 597);
INSERT INTO community(created_at, body, category, title, member_id, views)
VALUES ('2024-02-19 20:50:19.000000', '올래 회원이 된지 6개월 차입니다^^ 수업을 듣다 보니까 저도 가르치고 싶은 마음이 들더라고요. 올래 선생님이 되는 방법 아시는 분 좀 알려주세요~', 'QUESTION', '저도 올래 선생님 하고 싶은데 어떻게 하나요?', 1, 20008);
INSERT INTO community(created_at, body, category, title, member_id, views)
VALUES ('2024-02-18 22:50:19.000000', '혼자 했다가 부품이나 잘못 훼손되기라도 하면... 끔찍하기에 업체 맡겨 청소 쫙 하고 싶은데 요즘 본체 청소 괜찮은 곳 추천할 만한 곳 있나요? 보통 가격대는 얼마나 하', 'QUESTION', '컴퓨터 본체 청소 개인이 하시나요?', 1, 21052);
INSERT INTO community(created_at, body, category, title, member_id, views)
VALUES ('2024-02-18 23:50:19.000000', '안녕하세요~ 현재 대전 둔산동에서 보컬 학원 다니고 있는데 너무 괜찮은 것 같아서 소개해 드리고 싶어요~^^ 기초부터 탄탄히 가르쳐주고 바이브레이션도 잘 알려줍ㄴ', 'TOGETHER', '대전에 노래 잘하는 사람~', 1, 1542);
INSERT INTO community(created_at, body, category, title, member_id, views)
VALUES ('2024-02-18 23:50:19.000000', '겨울철이라 그런지 결로가 너무 심하네요... 벽에 곰팡이 피고 관리가 넘 어려워요 ~', 'QUESTION', '겨울철 결로 현상 ㅠㅠ', 1, 388);
INSERT INTO community(created_at, body, category, title, member_id, views)
VALUES ('2024-01-17 20:50:19.000000', '올래에서 수업 신청하면 문자로 알려주잖아요. 근데 저는 문자가 안와요.. 어떻게 해결하죠?', 'QUESTION', '수업 신청해도 문자가 안와요', 1, 20692);

INSERT INTO news(created_at, category, author, content, title, views, image_url)
VALUES ('2024-02-20 12:50:19.000000', 'HEALTH', '친절한 쩡아쌤',
        CONCAT('안녕하세요 올래를 이용하시는 회원님들을 위해 저 친절한 영이쌤이 건강 꿀팁을 가져왔습니다! 건강해지기 위해서 식탁에 반드시 올라가야 하는 음식들을 소개할게요!  \n\n',
               '1. 신선한 채소와 과일 : 신선한 채소와 과일은 비타민, 미네랄, 식이 섬유를 풍부하게 제공하여 면역력 강화와 소화를 도와요! 단, 당 함량이 높은 과일도 있으니 조심해야겠죠?  \n\n',
               '2. 단백질 : 건강한 근육을 유지하고 성장을 지원하기 위해 단백질이 필요합니다! 닭고기, 양고기, 생선, 콩, 견과류, 계란, 유제품 등을 통해 다양한 소스에서 단백질을 얻을 수 있어요. \n\n',
               '3. 지방 : 단백질과 탄수화물과 함께 건강한 지방도 중요합니다. 올리브 오일, 아보카도, 견과류, 어육류 중의 지방을 섭취하세요. 올래 회원님들! 음식보다 중요한 것은 양인거 알고 계시죠? 아무리 좋은 음식이라도 과하면 독이라는 것! \n',
               '적절한 비율로 식사하는 습관을 꼭 들이시길 바랍니다~ \n\n',
               '다음주에도 건강한 내 몸 챙기는 정보들 갖고 올게요!!'),
        '건강을 위해 반드시 지켜야 하는 식단!',30982, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/news/news8.png');
INSERT INTO news(created_at, category, author, content, title, views, image_url)
VALUES ('2024-02-20 11:50:19.000000', 'LIFE', '시골청년', '안정적인 경제적 터전을 마련하는 방편이기도 하지만 귀향하고 싶은 마음의 중장년을 위한 안정적인 귀농귀촌에 대한 정보를 소개합니다.', '도시를 떠난 삶을 위해 가장 먼저 가야 할 곳', 20912, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/news/news6.jpeg');
INSERT INTO news(created_at, category, author, content, title, views, image_url)
VALUES ('2024-02-19 11:50:19.000000', 'RECRUIT', '슬기로운취준생활', '퇴직 후 우울감을 느끼는 중장년 세대가 많은 요즘, 은퇴 후 설계의 사회적 의미를 확인할 수 있는 다양한 사회공헌활동에 대해 정보를 소개합니다.', '인생 2막 의미를 찾은 사회공헌활동 정보 2024', 23873, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/news/news7.jpeg');
INSERT INTO news(created_at, category, author, content, title, views, image_url)
VALUES ('2024-02-19 10:50:19.000000', 'LIFE', '생활통통', CONCAT('사회가 빠르게 변하면서 1인가구, 즉 혼자서 생활하는 집단이 점점 많아지고 있습니다. \n',
                                                             '통계청에서 2021년 발표한 연령별 1인 가구의 비중을 살펴보면 20대가 19.8%로 가장 높고, 60대가 16.4%, 50대가 15.4%로 차례로 비중이 높았습니다.\n',
                                                             '특히 “나홀로 삶” 을 살고 있는 중장년층은 삶의 만족도가 그렇지 않은 세대와 비교했을 때 현저히 낮으며, 건강 및 경제적 문제의 해결이 어렵습니다. 그래서 오늘은 1인 가구의 중장년층들도 삶의 질을 향상시킬 수 있게 하기 위해 국가에서 지원하는 사업에 대해 알아보겠습니다.\n',
                                                             '1. 1인가구 지원센터 2019년부터 운영하기 시작한 프로그램이에요. 상담을 통해 생활, 정책 정보를 제공하고 연계까지 지원해준답니다. 2023년에는 스마트폰 활용 강좌, 공예 체험 프로그램, 반려 식물 만들기, 집수리와 같은 주거 개선 프로그램, 탁구 활동 등 다양한 분야로 진행이 되었답니다! 올해에는 25개 전 자치구로 확대하고 온라인, 오프라인 모두 이용할 수 있도록 한다고 해요!\n',
                                                             '2. 서울시 병원 안심동행 서비스 혼자 사는 것에 대해 가장 걱정 되는 건 아무래도 아플 때죠. 병원에 가기 어려운 분들을 위해 병원 동행 및 퇴원 후 일상을 지원하는 프로그램이 있으니 걱정 마세요! 병원으로 출발할 때부터 귀가할 때까지 동행 매니저가 보호자처럼 동행해드릴 뿐만 아니라 접수, 수납, 약국 동행까지 도와드립니다.\n',
                                                             '오늘은 홀로 생활하는 분들을 위한 국가 지원 사업 정보를 가져와봤습니다. 조금이라도 도움이 됐길 바라며, 다음에는 더 유익한 정보를 가져와볼게요! 항상 건강하시길 바랍니다.'), '중장년 1인가구를 지켜주는 생활정보', 11923, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/news/news3.jpeg');
INSERT INTO news(created_at, category, author, content, title, views, image_url)
VALUES ('2024-02-18 11:50:19.000000', 'BOARD', '팀 올래', '안녕하세요, 팀 올래입니다! 아주 반가운 소식을 들고 왔습니다~(짝짝짝) 드디어 올래가 자체적으로 카카오톡 채널을 만들었어요! 이 채널을 추가하시면 앞', '올래 카카오톡 채널 추가!', 29102, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/news/news10.png');
INSERT INTO news(created_at, category, author, content, title, views, image_url)
VALUES ('2024-02-18 10:50:19.000000','HEALTH', '친절한 쩡아쌤', '2030년 대한민국 기대 수명은 85.2세로 ‘100세 시대’는 이제 얼마 남지 않은 듯 합니다. 하지만 노년의 평균 12년을 병상에서 지내야 한다는 통계도 나', '건강한 100세를 위한 중장년 건강 진단',9210, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/news/news1.jpeg');
INSERT INTO news(created_at, category, author, content, title, views, image_url)
VALUES ('2024-02-17 11:50:19.000000','RECRUIT', '빛이되어줄게', '위드코로나 시대로 일상이 회복되었지만, 여전히 자영업자 40%는 3년 이내에 여러 부담으로 인해 폐업을 고민할만큼 골목상권의 어려움은 지속되고 ', '자영업, 소상공인을 위한 지원정보',21901, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/news/news4.jpeg');
INSERT INTO news(created_at, category, author, content, title, views, image_url)
VALUES ('2024-02-16 20:50:19.000000','RECRUIT', '친절한 쩡아쌤', '지속적인 경제활동 욕구와 도전에도 불구하고 한국인들의 평균 은퇴 나이는 49세. 퇴직 후에도 중장년층의 창업을 지원하는 다양한 제도에 대해서 알아', '퇴직 후 창업을 준비하는 중장년을 위한 지원제도',8920, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/news/news2.jpeg');
INSERT INTO news(created_at, category, author, content, title, views, image_url)
VALUES ('2024-02-16 17:50:19.000000','LIFE', '여행을 떠나요', '추운 겨울도 조금씩 지나가고 있네요. 곧 봄이 오니 한번 여행 계획을 짜는 것도 좋겠죠? 생활 속 스트레스를 해소하고 새로운 변화를 줄 수 있는 서울에', '봄을 즐기는 행복 충전 서울 힐링여행',9281, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/news/news5.jpeg');
INSERT INTO news(created_at, category, author, content, title, views, image_url)
VALUES ('2024-02-16 15:50:19.000000','RECRUIT', '이전직전문가', '채용시장에서 실제 어떤 자격증이 유리하게 작용하고 있을까요?', '중장년 이직, 전직을 위한 자격증',819, 'https://olae-bucket.s3.ap-northeast-2.amazonaws.com/news/news7.jpeg');

-- 뉴스 상세 이미지
INSERT INTO news_image (image_url, news_id) VALUES ('https://olae-bucket.s3.ap-northeast-2.amazonaws.com/news/news8.png', 1);
INSERT INTO news_image (image_url, news_id) VALUES ('https://olae-bucket.s3.ap-northeast-2.amazonaws.com/news/news11.png', 1);
INSERT INTO news_image (image_url, news_id) VALUES ('https://olae-bucket.s3.ap-northeast-2.amazonaws.com/news/news12.png', 1);
INSERT INTO news_image (image_url, news_id) VALUES ('https://olae-bucket.s3.ap-northeast-2.amazonaws.com/news/news13.png', 4);
INSERT INTO news_image (image_url, news_id) VALUES ('https://olae-bucket.s3.ap-northeast-2.amazonaws.com/news/news14.png', 4);
INSERT INTO news_image (image_url, news_id) VALUES ('https://olae-bucket.s3.ap-northeast-2.amazonaws.com/news/news15.png', 4);