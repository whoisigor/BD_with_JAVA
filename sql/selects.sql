SELECT * FROM jogo;
SELECT * FROM jogador;
SELECT * FROM time;
SELECT * FROM jogo WHERE timea_cod=1;
SELECT * from jogo WHERE (timea_cod=1 AND timeb_cod=2);
SELECT * from jogo WHERE resultado='3x2';
SELECT * from jogador WHERE idade=21;
SELECT * from jogador WHERE time_cod=10;
SELECT * from jogador WHERE nome='Igor';
SELECT * from time WHERE data_fundacao='15/03/2008';
SELECT * from time WHERE (data_fundacao='15/03/2018' AND data_fundacao='16/01/2000');
SELECT * from jogo WHERE resultado='0x0'
