insert into blocks(id, block_name) values (1, 'Boston'),
                                           (2, 'Dubai'),
                                        (3, 'Geneva');

insert into service_chats(id, chat_id, service_id, block_id)
values
        (1, -441335534, 2, null),
        (2, -279913047, 1, null),
        (3, -491705952, 3, null),
        (4, -491705952, 8, null),
        (5, -491705952, 4, null);
        (6, -472136192, 9, null); programmer

 insert into services (id, picture_url, service_name)
 values
        (1, 'https://www.business.ru/images/001/1-78.jpg', ':recycle: Вызов Клининговой Компании'),
        (2, 'https://kit8.net/images/thumbnails/580/386/detailed/4/at__computer@2x.png', ':woman: Вызов Администратора'),
        (3, 'https://www.forwellness.ca/wp-content/uploads/2019/09/Plumber-Cartoon-201709-001.jpg', ':wrench: Вызов Техника'),
        (4, 'https://thumbs.dreamstime.com/z/snowman-broom-hat-big-nose-countryside-holding-broomstick-his-hand-86997447.jpg', ':snowman: Вызов Дворника'),
        (5, null, ':email: Жалобы и Предложения'),
        (6,'https://cdn-images-1.medium.com/max/1600/0*Tu3jmmNEe6Fd_ez_.gif', ':gear: Вызов Инженера');
        (9, 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.3amfOSbiGDVXmZNswXHmqQHaD6%26pid%3DApi&f=1', ':computer: Вызов программиста');

insert into subservices (id, service_id, subservice_name)
values
       (1, 1, 'Влажная уборка'),
       (2, 1, 'Уборка сан.узлов'),
       (3, 1, 'Прочее'),
       (4, 3, 'Установка доски, мебели, ручек и пр.'),
       (5, 3, 'Проблемы с приточно-вытяжной системой'),
       (6, 3, 'Проблемы с системой отопления(напольные конвектора)'),
       (7, 3, 'Замены системы освещения (лампы)'),
       (8, 3, 'Прочее'),
       (9, 4, 'Мусор на территории'),
       (10, 4, 'Сосульки, снег'),
       (11, 4, 'Уборка урн'),
       (13, 5, 'Жалоба'),
       (14, 5, 'Предложения по улучшению сервиса'),
       (15, 1, 'Вынос мусора');

 insert into users (id, name, password, role, surname, username)
 #values (1, 'admin', '$2y$12$/uW2504kzT896aTyftPPgOr.Z..j9S6rpKKk3cT4l2CWjGax2URIm', 'admin', 'admin', 'admin');
values (1, 'admin', '$2y$10$Pi751afNMeRDc5oYvUaanegwoQL29e5hKEkidjJIjPRwlDy819JHa', 'admin', 'admin', 'admin');


