--Insert Tabela TB_PROFILE
INSERT INTO `tb_perfil` (`criado`, `criado_por`, `perfil`) VALUES ('2016-07-26 15:41:00', 'suporte@helpeo.com.br', 'SUPER_ADMIN');
INSERT INTO `tb_perfil` (`criado`, `criado_por`, `perfil`) VALUES ('2016-07-26 15:41:00', 'suporte@helpeo.com.br', 'ADMIN');
INSERT INTO `tb_perfil` (`criado`, `criado_por`, `perfil`) VALUES ('2016-07-26 15:41:00', 'suporte@helpeo.com.br', 'USUARIO');

--Insert Tabela TB_ROLE
INSERT INTO `tb_role` (`criado`, `criado_por`, `role`) VALUES ('2016-07-26 15:45:57', 'suporte@helpeo.com.br', 'ROLE_SUPER_ADMIN');
INSERT INTO `tb_role` (`criado`, `criado_por`, `role`) VALUES ('2016-07-26 15:45:57', 'suporte@helpeo.com.br', 'ROLE_ADMIN');
INSERT INTO `tb_role` (`criado`, `criado_por`, `role`) VALUES ('2016-07-26 15:45:57', 'suporte@helpeo.com.br', 'ROLE_USER');

--Insert Tabela TB_PROFILE_ROLE
INSERT INTO `tb_perfil_role` (`role_id`, `perfil_id`) VALUES (1, 1);
INSERT INTO `tb_perfil_role` (`role_id`, `perfil_id`) VALUES (2, 2);
INSERT INTO `tb_perfil_role` (`role_id`, `perfil_id`) VALUES (3, 3);

--Insert Table tb_usuario
INSERT INTO `tb_usuario` (`criado`, `criado_por`,`data_criacao`, `email`, `enable`, `nome`, `senha`, `perfil_id`) VALUES ('2016-12-10 16:25:38','suporte@helpeo.com.br','2016-12-10 16:25:38','aoaristides@gmail.com',1,'Anderson O. Aristides','896e5ab9cdbe27a41f812b54adf17ccf966c20c81b19baf004af7d8b9dafea08',2);

--Insert Table tb_funcionario 
INSERT INTO `tb_funcionario` (`criado`, `criado_por`, `nome`, `tenant_id`) VALUES ('2016-12-10 16:25:38','suporte@helpeo.com.br', 'Maria Silva', 'apple');
INSERT INTO `tb_funcionario` (`criado`, `criado_por`, `nome`, `tenant_id`) VALUES ('2016-12-10 16:25:38','suporte@helpeo.com.br', 'Pedro Ricardo', 'apple');
INSERT INTO `tb_funcionario` (`criado`, `criado_por`, `nome`, `tenant_id`) VALUES ('2016-12-10 16:25:38','suporte@helpeo.com.br', 'João Santos', 'samsung');
INSERT INTO `tb_funcionario` (`criado`, `criado_por`, `nome`, `tenant_id`) VALUES ('2016-12-10 16:25:38','suporte@helpeo.com.br', 'Maria Pereira', 'samsung');
INSERT INTO `tb_funcionario` (`criado`, `criado_por`, `nome`, `tenant_id`) VALUES ('2016-12-10 16:25:38','suporte@helpeo.com.br', 'Rafael Fernando', 'sony');
INSERT INTO `tb_funcionario` (`criado`, `criado_por`, `nome`, `tenant_id`) VALUES ('2016-12-10 16:25:38','suporte@helpeo.com.br', 'Filipe Prestes', 'sony');
