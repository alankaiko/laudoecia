/*
Este arquivo é onde é definida árvore de menu.

os parametos da função add são:
@id 		int identificação do menu adicionado
@pid		int identificação do "menu pai" a qual o menu será adicionado. para root utilizar -1
@name		string nome do menu que irá aparecer
@url		string url do link do menu
@title		string descrição explicativa do menu. esta opção é mostrada no tooltip do menu
@open  		boolean que define se o menu será iniciado aberto ou nao.
@icon		string caminho da imagem de icone, caso queira alterar o icone padrão do menu
@iconOpen 	string caminho da imagem de icone, caso queira alterar o icone padrão do menu aberto
@keywords	string com palavras chaves do conteúdo. é utilizdo na pesquisa.

*/

var menu = new Array();
var id = 0;
var idPai = -1;

//root menu (id = 0)
menu[menu.length] = new Array(id++,idPai,'Introdução ao LaudoeCia', 'home.html', 'Página inicial', true, '', '', '');

// menu Instalando e Configurando o Sistema
idPai = id;
menu[menu.length] = new Array(id++,0,'1. Instalando e Configurando o Sistema', 'instalacao/home.html', 'Instalando e Configurando o Sistema', false, '', '', 'requisitos minimos hardware configurar');
menu[menu.length] = new Array(id++,idPai,'1.1. Preparando para Instalar o Sistema', 'instalacao/preparando_para_instalar_sistema.html', 'Preparando para Instalar o Sistema', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'1.2. Instalação do sistema', 'instalacao/instalacao_do_sistema.html', 'Instalação do Sistema', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'1.3. Como utilizar o LaudoeCia em rede', 'instalacao/instalacao_em_rede.html', 'Como utilizar o LaudoeCia em rede', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'1.4. Definindo controle de acesso', 'instalacao/controle_de_acesso.html', 'Definindo Controle de Acesso', false, '', '', 'usuario logado senha login auditoria acoes');
menu[menu.length] = new Array(id++,idPai,'1.5. Definindo diretório de gravação de vídeos', 'instalacao/diretorio_de_videos.html', 'Definindo Diretório de Gravação de Vídeos', false, '', '', 'pasta arquivos gravados');
menu[menu.length] = new Array(id++,idPai,'1.6. Alterando fundo de tela', 'instalacao/fundo_de_tela.html', 'Alterando Fundo de Tela', false, '', '', 'papel parede personalizar');
menu[menu.length] = new Array(id++,idPai,'1.7. Definindo informações do licenciado', 'instalacao/licenciado.html', 'Definindo informações do licenciado', false, '', '', 'estabelecimeto');
menu[menu.length] = new Array(id++,idPai,'1.8. Configurando a impressão dos laudos', 'instalacao/conf_impressao_laudos.html', 'Configurando a Impressão dos Laudos', false, '', '', 'configurar margem margens papel superior inferior esquerda direita layout cabecalho rodape logomarca paginas');
menu[menu.length] = new Array(id++,idPai,'1.9. Como fazer backup e configurar backup automático', 'instalacao/conf_backup.html', 'Como fazer backup e configurar backup automático', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'2.0. Configurando dispositivo de captura', 'instalacao/conf_captura.html', 'Configurando dispositivo de captura', false, '', '', 'configurar dispositivos');

// menu Conhecendo o LaudoeCia
idPai = id;
menu[menu.length] = new Array(id++,0,'2. Conhecendo o LaudoeCia', 'conheca/home.html', 'Conhecendo o LaudoeCia', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'2.1. A tela inicial', 'conheca/tela_inicial.html', 'Conhecendo a tela inicial', false, '', '', 'splash inicio inicializacao carregar login fundo tela status');
menu[menu.length] = new Array(id++,idPai,'2.2. Os menus principais', 'conheca/menu principal.html', 'Conhecendo os menus principais', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'2.3. As telas de cadastros', 'conheca/telas_crud.html', 'As telas de cadastros', false, '', '', 'barra controle navegação registros tabela buscas');
menu[menu.length] = new Array(id++,idPai,'2.4. Campos de Formulários', 'conheca/campos_form.html', 'Campos de Formulários', false, '', '', 'preenchimento obrigatorio auto completar editor textos corretor ortografico corrigir erro');
menu[menu.length] = new Array(id++,idPai,'2.5. Teclas de atalhos', 'conheca/teclas_de_atalho.html', 'Teclas de atalhos', false, '', '', '');

// menu Menu Cadastros
idPai = id;
menu[menu.length] = new Array(id++,0,'3. Menu Cadastros', 'cadastros/home.html', 'Ajuda do Menu Cadastros', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'3.1. Cadastrar convênios médicos', 'cadastros/convenios.html', 'Cadastar convênios médicos', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'3.2. Cadastrar exames e procedimentos médicos', 'cadastros/exames.html', 'Cadastrar Exames e procedimentos médicos', false, '', '', 'restricao sexo dias entrega tabela precos modelos laudo');
menu[menu.length] = new Array(id++,idPai,'3.3. Cadastrar grupos de exames e procedimentos', 'cadastros/grupos_de_exames.html', 'Cadastrar grupos de exames e procedimentos', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'3.4. Cadastrar pacientes', 'cadastros/pacientes.html', 'Cadastrar pacientes', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'3.5. Cadastrar profissionais executantes (médicos)', 'cadastros/prof_executante.html', 'Cadastrar profissionais executantes (médicos)', false, '', '', 'frase pessoal assinatura');
menu[menu.length] = new Array(id++,idPai,'3.6. Cadastrar profissionais solicitantes (médicos)', 'cadastros/prof_solicitantes.html', 'Cadastrar profissionais solicitantes (médicos)', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'3.7. Cadastrar textos pessoais', 'cadastros/textos_pessoais.html', 'Cadastrar textos pessoais', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'3.8. Cadastrar grupos de usuário (perfis de acesso)', 'cadastros/grupo_de_usuarios.html', 'Cadastrar grupos de usuário (perfis de acesso)', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'3.9. Cadastrar usuários', 'cadastros/usuarios.html', 'Cadastrar usuários', false, '', '', '');

// menu Operações de Atendimento
idPai = id;
menu[menu.length] = new Array(id++,0,'4. Operações de Atendimento', 'operacoes/home.html', 'Operações de Atendimento', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'4.1. Ficha de Atendimento', 'operacoes/atendimento.html', 'Ficha de atendimento a pacientes', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'4.2. Tela de Laudo e Captura', 'operacoes/tela_laudo_captura.html', 'Tela de Laudo e Captura', false, '', '', '');
var idPaiAux = id;
menu[menu.length] = new Array(id++,idPai,'4.3. Módulo de Captura', 'operacoes/captura/home.html', 'Módulo de Captura', true, '', '', '');
menu[menu.length] = new Array(id++,idPaiAux,'4.3.1. Capturando imagens para o laudo', 'operacoes/captura/captura.html', 'Capturando imagens para o laudo', false, '', '', '');
menu[menu.length] = new Array(id++,idPaiAux,'4.3.2. Editando uma imagem', 'operacoes/captura/editar_imagem.html', 'Editando uma imagem	', false, '', '', '');
menu[menu.length] = new Array(id++,idPaiAux,'4.3.3. Gravando vídeo do exame', 'operacoes/captura/grava_video.html', 'Gravando vídeo do exame', false, '', '', '');
menu[menu.length] = new Array(id++,idPaiAux,'4.3.4. Reproduzir vídeo do exame', 'operacoes/captura/reproduz_video.html', 'Reproduzir vídeo do exame', false, '', '', '');
menu[menu.length] = new Array(id++,idPaiAux,'4.3.5. Exportar imagens e vídeos capturados', 'operacoes/captura/exportar_imagens_videos.html', 'Exportar imagens e vídeos capturados', false, '', '', '');
idPaiAux = id;
menu[menu.length] = new Array(id++,idPai,'4.4. Módulo de Laudos', 'operacoes/laudo/home.html', 'Módulo de Laudos', true, '', '', '');
menu[menu.length] = new Array(id++,idPaiAux,'4.4.1. Escolhendo Modelo de Laudo', 'operacoes/laudo/escolher_modelo.html', 'Escolhendo Modelo de Laudo', false, '', '', '');
menu[menu.length] = new Array(id++,idPaiAux,'4.4.2. Tópicos do Laudo', 'operacoes/laudo/topicos.html', 'Tópicos do Laudo', false, '', '', '');
menu[menu.length] = new Array(id++,idPaiAux,'4.4.3. Preenchendo campos do laudo', 'operacoes/laudo/campos_do_laudo.html', 'Preenchendo campos do laudo', false, '', '', '');
menu[menu.length] = new Array(id++,idPaiAux,'4.4.4. Inserindo textos pessoais', 'operacoes/laudo/texto_pessoal.html', 'Inserindo textos pessoais', false, '', '', 'texto pessoal');
menu[menu.length] = new Array(id++,idPaiAux,'4.4.5. Visualizar e editar o laudo', 'operacoes/laudo/visualizar_editar_laudo.html', 'Visualizar e editar o laudo', false, '', '', '');
menu[menu.length] = new Array(id++,idPaiAux,'4.4.6. Escolher layout e imagens para impressão', 'operacoes/laudo/escolher_imagens.html', 'Escolher layout e imagens para impressão', false, '', '', '');
menu[menu.length] = new Array(id++,idPaiAux,'4.4.7. Imprimindo e exportando PDF do laudo', 'operacoes/laudo/imprimir_pdf.html', 'Imprimindo e exportando PDF do laudo', false, '', '', '');

// menu Relatorios do Sistema
idPai = id;
menu[menu.length] = new Array(id++,0,'5. Relatórios do Sistema', 'relatorios/home.html', 'Relatórios do Sistema', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'5.1. Relatórios de atendimento', 'relatorios/rel_atendimentos.html', 'Relatórios de Atendimento', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'5.2. Auditoria do banco de dados', 'relatorios/rel_auditoria.html', 'Auditoria do banco de dados', false, '', '', '');

// menu Outras Opções do Sistema
idPai = id;
menu[menu.length] = new Array(id++,0,'6. Outras Opções do Sistema', 'outras/home.html', 'Outras opções do Sistema', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'6.1. Bases de Dados', 'outras/base_de_dados.html', 'Bases de Dados', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'6.2. Alternar usuário logado', 'outras/alternar_usuario.html', 'Alternar usuário logado', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'6.3. Suspender sessão', 'outras/suspender_sessao.html', 'Alternar usuário logado', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'6.4. Estações de trabalho', 'outras/estacoes.html', 'Estações de trabalho', false, '', '', '');

// menu Dúvidas e Problemas Frequentes
idPai = id;
menu[menu.length] = new Array(id++,0,'7. Dúvidas e Problemas Frequentes', 'duvidas/home.html', 'Dúvidas e Problemas Frequentes', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'7.1. Lista de abreviações', 'duvidas/abreviacoes.html', 'Lista de abreviações', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'7.2. Restaurar backup dos dados', 'duvidas/restore.html', 'Restaurar backup dos dados', false, '', '', '');
menu[menu.length] = new Array(id++,idPai,'7.3. Problemas com a captura de imagens', 'duvidas/captura_imagens.html', 'Problemas com a captura de imagens', false, '', '', '');

