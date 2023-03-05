insert into equipe (nome, img) values
('Atlanta Hawks', 'https://loodibee.com/wp-content/uploads/nba-atlanta-hawks-logo.png'),
('Boston Celtics', 'https://loodibee.com/wp-content/uploads/nba-boston-celtics-logo.png'),
('Brooklyn Nets', 'https://loodibee.com/wp-content/uploads/nba-brooklyn-nets-logo.png'),
('Charlotte Hornets', 'https://loodibee.com/wp-content/uploads/nba-charlotte-hornets-logo.png'),
('Chicago Bulls', 'https://loodibee.com/wp-content/uploads/nba-chicago-bulls-logo.png'),
('Cleveland Cavaliers', 'https://loodibee.com/wp-content/uploads/Clevelan-Cavaliers-logo-2022.png'),
('Dallas Mavericks', 'https://loodibee.com/wp-content/uploads/dallas-mavericks-logo-symbol.png'),
('Denver Nuggets', 'https://loodibee.com/wp-content/uploads/nba-denver-nuggets-logo-2018.png'),
('Detroit Pistons', 'https://loodibee.com/wp-content/uploads/nba-detroit-pistons-logo.png'),
('Golden State Warriors', 'https://loodibee.com/wp-content/uploads/nba-golden-state-warriors-logo-2020.png'),
('Houston Rockets', 'https://loodibee.com/wp-content/uploads/nba-houston-rockets-logo-2020.png'),
('Indiana Pacers', 'https://loodibee.com/wp-content/uploads/nba-indiana-pacers-logo.png'),
('Los Angeles Clippers', 'https://loodibee.com/wp-content/uploads/los-angeles-clippers-logo-symbol.png'),
('Los Angeles Lakers', 'https://loodibee.com/wp-content/uploads/nba-los-angeles-lakers-logo.png'),
('Memphis Grizzlies', 'https://loodibee.com/wp-content/uploads/nba-memphis-grizzlies-logo.png'),
('Miami Heat', 'https://loodibee.com/wp-content/uploads/nba-miami-heat-logo.png'),
('Milwaukee Bucks', 'https://loodibee.com/wp-content/uploads/nba-milwaukee-bucks-logo.png'),
('Minnesota Timberwolves', 'https://loodibee.com/wp-content/uploads/nba-minnesota-timberwolves-logo.png'),
('New Orleans Pelicans', 'https://loodibee.com/wp-content/uploads/nba-new-orleans-pelicans-logo.png'),
('New York Knicks', 'https://loodibee.com/wp-content/uploads/nba-new-york-knicks-logo.png'),
('Oklahoma City Thunder', 'https://loodibee.com/wp-content/uploads/oklahoma-city-thunder-logo-symbol.png'),
('Orlando Magic', 'https://loodibee.com/wp-content/uploads/nba-orlando-magic-logo.png'),
('Philadelphia 76ers', 'https://loodibee.com/wp-content/uploads/nba-philadelphia-76ers-logo.png'),
('Phoenix Suns', 'https://loodibee.com/wp-content/uploads/phoenix-suns-logo-symbol.png'),
('Portland Trail Blazers', 'https://loodibee.com/wp-content/uploads/portland-trail-blazers-logo-symbol.png'),
('Sacramento Kings', 'https://loodibee.com/wp-content/uploads/nba-sacramento-kings-logo.png'),
('San Antonio Spurs', 'https://loodibee.com/wp-content/uploads/san-antonio-spurs-logo-symbol.png'),
('Toronto Raptors', 'https://loodibee.com/wp-content/uploads/nba-toronto-raptors-logo-2020.png'),
('Utah Jazz', 'https://loodibee.com/wp-content/uploads/utah-jazz-logo-2022.png'),
('Washington Wizards', 'https://loodibee.com/wp-content/uploads/nba-washington-wizards-logo.png');

insert into usuario (email, nome, data_nascimento, senha, equipe_id, ativo)
 values ('admin@cwi.com.br', 'admin', '1999/03/22','$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', 26,true);
insert into usuario (email, nome, data_nascimento, senha, equipe_id, ativo)
 values ('usuario@cwi.com.br', 'usuario', '1999/03/22','$2a$10$VrIbJURwINOR5HOrWFFTNOwSILsioRJSuOGAg8Luvr9qZDSOl5JXG', 26, true);

insert into permissao (funcao, usuario_id) values ('USUARIO', 1);
insert into permissao (funcao, usuario_id) values ('USUARIO', 2);