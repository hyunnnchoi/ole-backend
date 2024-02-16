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

INSERT INTO news(created_at, category, author, content, title, views)
VALUES ('2024-02-20 12:50:19.000000', 'HEALTH', '친절한 쩡아쌤', '안녕하세요, 쩡이쌤입니다! 건강을 위해 반드시 지켜야 하는 식단 다섯가지를 가져왔습니다!', '건강을 위해 반드시 지켜야 하는 식단!',30982);
INSERT INTO news(created_at, category, author, content, title, views)
VALUES ('2024-02-20 11:50:19.000000', 'LIFE', '시골청년', '안정적인 경제적 터전을 마련하는 방편이기도 하지만 귀향하고 싶은 마음의 중장년을 위한 안정적인 귀농귀촌에 대한 정보를 소개합니다.', '도시를 떠난 삶을 위해 가장 먼저 가야 할 곳',20912);
INSERT INTO news(created_at, category, author, content, title, views)
VALUES ('2024-02-19 11:50:19.000000','RECRUIT', '슬기로운취준생활', '퇴직 후 우울감을 느끼는 중장년 세대가 많은 요즘, 은퇴 후 설계의 사회적 의미를 확인할 수 있는 다양한 사회공헌활동에 대해 정보를 소개합니다.', '인생 2막 의미를 찾은 사회공헌활동 정보 2024',23873);
INSERT INTO news(created_at, category, author, content, title, views)
VALUES ('2024-02-19 10:50:19.000000','LIFE', '생활통통', '해가 거듭될수록 더욱 두드러지게 늘어나고 있는 중장년층 1인가구. 가족과 함께하는 세대에 비해 삶의 만족도가 급격히 하락하고, 건강, 사회적 고립, ', '중장년 1인가구를 지켜주는 생활정보',11923);
INSERT INTO news(created_at, category, author, content, title, views)
VALUES ('2024-02-18 11:50:19.000000','BOARD', '팀 올래', '안녕하세요, 팀 올래입니다! 아주 반가운 소식을 들고 왔습니다~(짝짝짝) 드디어 올래가 자체적으로 카카오톡 채널을 만들었어요! 이 채널을 추가하시면 앞', '올래 카카오톡 채널 추가!',29102);
INSERT INTO news(created_at, category, author, content, title, views)
VALUES ('2024-02-18 10:50:19.000000','HEALTH', '친절한 쩡아쌤', '2030년 대한민국 기대 수명은 85.2세로 ‘100세 시대’는 이제 얼마 남지 않은 듯 합니다. 하지만 노년의 평균 12년을 병상에서 지내야 한다는 통계도 나', '건강한 100세를 위한 중장년 건강 진단',9210);
INSERT INTO news(created_at, category, author, content, title, views)
VALUES ('2024-02-17 11:50:19.000000','RECRUIT', '빛이되어줄게', '위드코로나 시대로 일상이 회복되었지만, 여전히 자영업자 40%는 3년 이내에 여러 부담으로 인해 폐업을 고민할만큼 골목상권의 어려움은 지속되고 ', '자영업, 소상공인을 위한 지원정보',21901);
INSERT INTO news(created_at, category, author, content, title, views)
VALUES ('2024-02-16 20:50:19.000000','RECRUIT', '친절한 쩡아쌤', '지속적인 경제활동 욕구와 도전에도 불구하고 한국인들의 평균 은퇴 나이는 49세. 퇴직 후에도 중장년층의 창업을 지원하는 다양한 제도에 대해서 알아', '퇴직 후 창업을 준비하는 중장년을 위한 지원제도',8920);
INSERT INTO news(created_at, category, author, content, title, views)
VALUES ('2024-02-16 17:50:19.000000','LIFE', '여행을 떠나요', '추운 겨울도 조금씩 지나가고 있네요. 곧 봄이 오니 한번 여행 계획을 짜는 것도 좋겠죠? 생활 속 스트레스를 해소하고 새로운 변화를 줄 수 있는 서울에', '봄을 즐기는 행복 충전 서울 힐링여행',9281);
INSERT INTO news(created_at, category, author, content, title, views)
VALUES ('2024-02-16 15:50:19.000000','RECRUIT', '이전직전문가', '채용시장에서 실제 어떤 자격증이 유리하게 작용하고 있을까요?', '중장년 이직, 전직을 위한 자격증',819);

INSERT INTO file(name, lesson_id, member_id, news_id) VALUES ('뉴스 테스트', null, null, 1);
INSERT INTO file(name, path, represent, lesson_id, member_id, news_id) VALUES ('test', 'resources/static/test.png', FALSE, null, null, 1);

INSERT INTO file(name, lesson_id, member_id, news_id) VALUES ('뉴스 테스트', null, null, 2);
INSERT INTO file(name, lesson_id, member_id, news_id) VALUES ('뉴스 테스트', null, null, 3);
INSERT INTO file(name, lesson_id, member_id, news_id) VALUES ('뉴스 테스트', null, null, 4);