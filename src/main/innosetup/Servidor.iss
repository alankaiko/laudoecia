;Dados do programa
#define MyAppId "{{06D4709A-A7BE-4EE0-BBE6-D3BD28D2FF21}"
#define MyAppName "LaudoeCia"
#define MyAppPublisher "J M De Paula Nova OpçãoMed-ME"
#define MyAppSite "http://www.laudoecia.com.br"
#define MyAppVersion "1.9.9.1"        

;Database
#define DatabasePassword "Joao1030"
#define DatabasePort "5434"
#define DatabaseSuperUser "teknamed"
#define ServicePassword "1Joao418"
#define ServiceUser "teknamedpg" 

;Arquivos
#define MyAppExe "LaudoeCia.jar"
#define MyAppExeSemSplash "LaudoeCia-sem splash.jar"
#define MyAppBat "LaudoeCia.bat"
#define LaudoeCiaBak "LaudoeCiaBak.bat"
#define NomeArquivoPcId "pc_id.lc"
#define PastaFerramentas "utils"
#define Suporte "TeamViewerQS_pt.exe"
#define Resources "..\..\..\resources\setup\"
#define IsResources "is-resources\"
#define Dist "..\..\..\target\dist\" 
#define OutputDir "..\..\..\dist"

;Configurações
#define PdfSite "http://www.tracker-software.com/product/pdf-xchange-viewer"

[Setup]
AppId={#MyAppId}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
AppPublisher={#MyAppPublisher}
ChangesEnvironment=yes
Compression=lzma
DefaultDirName=C:\{#MyAppName}
DefaultGroupName={#MyAppName}
DisableDirPage=auto
DisableProgramGroupPage=auto
LicenseFile={#Resources}{#IsResources}licenca.txt
OutputBaseFilename={#MyAppName}
OutputDir={#OutputDir}
PrivilegesRequired=admin
SetupIconFile={#Resources}{#IsResources}icone.ico
SolidCompression=yes
VersionInfoVersion={#MyAppVersion}
WizardImageFile={#Resources}{#IsResources}WizardImageFile.bmp
WizardSmallImageFile={#Resources}{#IsResources}WizardSmallImageFile.bmp
             
[Languages]
Name: brazilianportuguese; MessagesFile: compiler:Languages\BrazilianPortuguese.isl

[Tasks]
Name: desktopicon; Description: {cm:CreateDesktopIcon}; GroupDescription: {cm:AdditionalIcons}

[Files]
Source: {#Dist}ext\*; DestDir: {app}\bin\ext; Flags: onlyifdoesntexist
Source: {#Dist}help\*; DestDir: {app}\bin\help; Flags: recursesubdirs createallsubdirs
Source: {#Dist}jmf\*; DestDir: {app}\bin\jmf; Flags: onlyifdoesntexist
Source: {#Dist}lib\*; DestDir: {app}\bin\lib; Flags: onlyifdoesntexist
Source: {#Dist}properties\*; DestDir: {app}\bin\properties; Flags: onlyifdoesntexist
Source: {#Dist}recursos\*.wav; DestDir: {app}\bin\recursos; Flags: onlyifdoesntexist
Source: {#Dist}recursos\IMAGEM_DE_FUNDO.jpg; DestDir: {app}\bin\recursos; Flags: onlyifdoesntexist
Source: {#Dist}recursos\bkpInstall.backup; DestDir: {app}\bin\recursos; Flags: deleteafterinstall; Check: InstalarPg83
Source: {#Dist}recursos\bkpRestore.backup; DestDir: {app}\bin\recursos
Source: {#Dist}recursos\pg_hba.conf; DestDir: {app}\{#PastaFerramentas}
Source: {#Dist}userdict\user*; DestDir: {app}\bin\userdict; Flags: onlyifdoesntexist
Source: {#Dist}userdict\pt_BR.dic; DestDir: {app}\bin\userdict; Flags: onlyifdoesntexist
Source: {#Dist}userdict\pt_BR.aff; DestDir: {app}\bin\userdict; Flags: onlyifdoesntexist
Source: {#Dist}*.jar; DestDir: {app}\bin;
Source: {#Dist}jmf.properties; DestDir: {app}\bin; Flags: onlyifdoesntexist
Source: {#Dist}soundbank.gm; DestDir: {app}\bin; Flags: onlyifdoesntexist
Source: {#Resources}{#IsResources}icone.ico; DestDir: {app}\bin; Flags: onlyifdoesntexist
Source: {#Resources}vm\*; DestDir: {app}\bin\vm; Flags: recursesubdirs
Source: {#Resources}JMF\DLLs\*; DestDir: {sys}; Flags: onlyifdoesntexist
Source: {#Resources}TeamViewer\TeamViewerQS_pt.exe; DestDir: {app}\{#PastaFerramentas}
Source: {#Resources}Captura\Teste de captura.exe; DestDir: {app}\{#PastaFerramentas}
Source: {#OutputDir}\{#MyAppName}-Terminal.exe; DestDir: {app}; DestName: {#MyAppName} - Terminal.exe 
Source: {#Resources}Postgres\vcredist_x86.exe; DestDir: {app}\{#PastaFerramentas}; Check: BdSeraInstalado; Flags: deleteafterinstall onlyifdoesntexist
Source: {#Resources}Postgres\netuser.cmd; DestDir: {app}\{#PastaFerramentas}; Check: BdSeraInstalado; Flags: deleteafterinstall onlyifdoesntexist
Source: {#Resources}Postgres\postgresql-8.3-int.msi; DestDir: {app}\{#PastaFerramentas}; Check: InstalarPg83; Flags: deleteafterinstall onlyifdoesntexist

[Icons]
Name: {code:GrupoDoMenuIniciar}\Abrir o {#MyAppName}; Filename: {app}\bin\{#MyAppBat}; IconFilename: {app}\bin\icone.ico; Comment: Clique para iniciar o {#MyAppName}; HotKey: "ctrl+alt+l"
Name: {code:GrupoDoMenuIniciar}\{cm:UninstallProgram,{#MyAppName}}; Filename: {uninstallexe}; Comment: Clique para desinstalar o {#MyAppName}
Name: {code:GrupoDoMenuIniciar}\Ferramentas; Filename: {app}\{#PastaFerramentas}; Comment: Abre a pasta de ferramentas úteis ao {#MyAppName}; Flags: runmaximized
Name: {code:GrupoDoMenuIniciar}\Manual; Filename: {app}\bin\help\index.html; Comment: Abre o manual do {#MyAppName}; Flags: runmaximized
Name: {code:GrupoDoMenuIniciar}\{#MyAppName} na internet; Filename: {#MyAppSite}; Flags: runmaximized              
Name: {code:GrupoDoMenuIniciar}\Programa para leitura de PDF; Filename: {#PdfSite}; Flags: runmaximized                                                                                                  
Name: {userdesktop}\{#MyAppName}; Filename: {app}\bin\LaudoeCia.bat; WorkingDir: {app}\bin; IconFilename: {app}\bin\icone.ico; IconIndex: 0; Flags: closeonexit createonlyiffileexists; Comment: Clique duas vezes para iniciar o {#MyAppName}; Tasks: desktopicon
Name: {userdesktop}\Suporte remoto; Filename: {app}\{#PastaFerramentas}\TeamViewerQS_pt.exe; WorkingDir: {app}\{#PastaFerramentas}; IconFilename: {app}\{#PastaFerramentas}\TeamViewerQS_pt.exe; IconIndex: 0; Flags: closeonexit createonlyiffileexists; Comment: Clique duas vezes para iniciar o suporte remoto; Tasks: desktopicon

[Registry]
Root: HKLM; Subkey: SOFTWARE\Microsoft\Windows\CurrentVersion\Run; ValueType: string; ValueName: {#MyAppName}; ValueData: """{app}\bin\{#LaudoeCiaBak}"""; Flags: uninsdeletevalue
Root: HKCU; Subkey: "Environment"; ValueType: expandsz; ValueName: "CLASSPATH"; ValueData: ".;{olddata}"; Check: NeedsAddPath('.')
Root: HKCU; Subkey: "Environment"; ValueType: expandsz; ValueName: "CLASSPATH"; ValueData: "{app}\bin\lib\jmf.jar;{olddata}"; Check: NeedsAddPath('{app}\bin\lib\jmf.jar')
Root: HKCU; Subkey: "Environment"; ValueType: expandsz; ValueName: "CLASSPATH"; ValueData: "{app}\bin\lib\sound.jar;{olddata}"; Check: NeedsAddPath('{app}\bin\lib\sound.jar')
Root: HKCU; Subkey: "Environment"; ValueType: expandsz; ValueName: "CLASSPATH"; ValueData: "{app}\bin\lib;{olddata}"; Check: NeedsAddPath('{app}\bin\lib')
                              
[Run]
Filename: {app}\{#PastaFerramentas}\netuser.cmd; WorkingDir: {sys}; StatusMsg: Preparando instalação do banco de dados; Check: BdSeraInstalado; Flags: runhidden waituntilterminated shellexec
Filename: {app}\{#PastaFerramentas}\vcredist_x86.exe; WorkingDir: {sys}; StatusMsg: Instalando Microsoft Visual C++ 2005; Check: BdSeraInstalado
Filename: {sys}\msiexec.exe; StatusMsg: Instalando PostgreSQL 8.3; Check: InstalarPg83; parameters: " /i ""{app}\{#PastaFerramentas}\postgresql-8.3-int.msi"" /qr INTERNALLAUNCH=1 ADDLOCAL=server,psql,pgadmin PERMITREMOTE=1 CREATESERVICEUSER=1 DOSERVICE=1 DOINITDB=1 SERVICEACCOUNT=""{#ServiceUser}"" SERVICEPASSWORD=""{#ServicePassword}"" SUPERUSER=""{#DatabaseSuperUser}"" SUPERPASSWORD=""{#DatabasePassword}"" ENCODING=""UTF-8"" TRANSFORMS=:lang_pt_br LISTENPORT={#DatabasePort} BASEDIR=""{pf}\PostgreSQL\8.3"" DATADIR=""{code:GetDataDir}"""
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExe}"" instalador {code:BdPrecisouSerInstalado} ""{code:GetDataDir}"""; Flags: hidewizard
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" backup"; Check: MoverArquivoPcId; Flags: nowait
Filename: {app}\bin\{#MyAppBat}; Description: {cm:LaunchProgram,{#StringChange(MyAppName, '&', '&&')}}; Flags: shellexec postinstall skipifsilent
Filename: {sys}\netsh.exe; StatusMsg: Configurando firewall; parameters: "advfirewall firewall add rule name=""Abertura da porta 5434 para o Postgres"" dir=in action=allow protocol=TCP localport=5434"; Flags: shellexec runhidden nowait 
[Code]

var
  IconGroup: String;
  InstalarBancoDeDados: Boolean;
  Pg83EstaInstal: Boolean;
  Pg83LcEstaInstal: Boolean;
  VersaoDoLaudoeCia: String;
  DataDirPage: TInputDirWizardPage;

procedure FecharBkpManager();
var
  ResultCode: Integer;
begin
  Exec(ExpandConstant('{app}\bin\vm\bin\javaw.exe'), ExpandConstant(' -jar "{app}\bin\{#MyAppExeSemSplash}" fecharbkpmanager'), '', SW_SHOW, ewWaitUntilTerminated, ResultCode);  
end;

function InitializeSetup(): Boolean;
var
  LaudoeCiaEstaInstalado: Boolean;  
begin
  IconGroup := ExpandConstant('{#MyAppName}');
  LaudoeCiaEstaInstalado := RegQueryStringValue(HKEY_LOCAL_MACHINE, ExpandConstant('SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall\{#MyAppId}_is1'), 'DisplayVersion', VersaoDoLaudoeCia);
  If LaudoeCiaEstaInstalado Then
    begin
    If (VersaoDoLaudoeCia = '1.0.0') Or (VersaoDoLaudoeCia = '1.0.1') Or (VersaoDoLaudoeCia = '1.0.2') Or (VersaoDoLaudoeCia = '1.1.0') Or (VersaoDoLaudoeCia = '1.1.1') Or (VersaoDoLaudoeCia = '1.2.0') Or (VersaoDoLaudoeCia = '1.3.0') Or (VersaoDoLaudoeCia = '1.3.1') Or (VersaoDoLaudoeCia = '1.4.0') Or (VersaoDoLaudoeCia = '1.5.0') Or (VersaoDoLaudoeCia = '1.6.0') Or (VersaoDoLaudoeCia = '1.7.0') Or (VersaoDoLaudoeCia = '1.8.0') Or (VersaoDoLaudoeCia = '1.9.0') Or (VersaoDoLaudoeCia = '1.9.1') Or (VersaoDoLaudoeCia = '1.9.2') Or (VersaoDoLaudoeCia = '1.9.3') Or (VersaoDoLaudoeCia = '1.9.4') Or (VersaoDoLaudoeCia = '1.9.4.1') Or (VersaoDoLaudoeCia = '1.9.4.2') Or (VersaoDoLaudoeCia = '1.9.4.3') Or (VersaoDoLaudoeCia = '1.9.4.4') Or (VersaoDoLaudoeCia = '1.9.5') Or (VersaoDoLaudoeCia = '1.9.5.1') Or (VersaoDoLaudoeCia = '1.9.6') Or (VersaoDoLaudoeCia = '1.9.6.1') Or (VersaoDoLaudoeCia = '1.9.6.2') Or (VersaoDoLaudoeCia = '1.9.7.0') Or (VersaoDoLaudoeCia = '1.9.8.0') Or (VersaoDoLaudoeCia = '1.9.9.0') Then
      begin
      Result := False;
      MsgBox(ExpandConstant('O {#MyAppName} já está instalado. Faça o download do atualizador para obter a versão {#MyAppVersion}.'), mbInformation, MB_OK);
      end
    Else
      begin
      Result := False;
      MsgBox(ExpandConstant('Você já possui a versão mais recente do {#MyAppName}.'), mbInformation, MB_OK);
      end
    end    
  Else
    Result := True;        
end;

function CreateBatchFile(): boolean;
var
  fileName : string;
  instDir : string;
  lines : TArrayOfString;
begin
  Result := true;
  instDir := ExpandConstant('start "" "{app}\bin\vm\bin\javaw.exe" -Xmx512M -jar "{app}\bin\LaudoeCia.jar" backup');
  fileName := ExpandConstant('{app}\bin\LaudoeCiaBak.bat');
  SetArrayLength(lines, 1);
  lines[0] := instDir;
  Result := SaveStringsToFile(filename,lines,true);
  exit;
end;
function CreateBatchFileStart(): boolean;
var
  fileName : string;
  instDir : string;
  lines : TArrayOfString;
begin
  Result := true;
  instDir := ExpandConstant('start "" "{app}\bin\vm\bin\javaw.exe" -Xmx1024M -jar "{app}\bin\LaudoeCia.jar"');
  fileName := ExpandConstant('{app}\bin\LaudoeCia.bat');
  SetArrayLength(lines, 1);
  lines[0] := instDir;
  Result := SaveStringsToFile(filename,lines,true);
  exit;
end;

function GrupoDoMenuIniciar(Param: String): String;
begin
  Result := ExpandConstant('{group}');
end;

function InstalarPg83(): Boolean;
begin
  Result := InstalarBancoDeDados And Not (Pg83EstaInstal Or Pg83LcEstaInstal);   
end;

function BdPrecisouSerInstalado(Param: String): String;
begin
  If InstalarPg83() Then
    Result := 'T'
  Else
    Result := 'F';
end;

function BdSeraInstalado(): Boolean;
begin
  Result := InstalarBancoDeDados;
end;

function MoverArquivoPcId(): Boolean;
var
  Origem, Destino: String;
begin  
  Origem := ExpandConstant('{app}\bin\recursos\{#NomeArquivoPcId}');
  Destino := ExpandConstant('{sys}\{#NomeArquivoPcId}');
  FileCopy(Origem, Destino, False);
  DeleteFile(Origem);
  Result := True;
end;

procedure CurStepChanged(CurStep: TSetupStep);
var
  ResultStr: String;
begin
  If CurStep = ssInstall Then
  begin 
    Pg83EstaInstal := RegQueryStringValue(HKEY_LOCAL_MACHINE, 'SOFTWARE\PostgreSQL\Installations\{B823632F-3B72-4514-8861-B961CE263224}', 'Version', ResultStr);
    If Pg83EstaInstal And RegQueryStringValue(HKEY_LOCAL_MACHINE, 'SOFTWARE\PostgreSQL\Services\pgsql-8.3', 'Database Superuser', ResultStr) Then
      Pg83LcEstaInstal := (ResultStr = '{#DatabaseSuperUser}')
    Else 
      Pg83LcEstaInstal := False;
    If Pg83LcEstaInstal Then
      InstalarBancoDeDados := False
    Else
      begin
      If Pg83EstaInstal Then
        begin
        MsgBox('Conflito na instalação do banco de dados. Contate o suporte técnico.', mbInformation, MB_OK);
        Abort;
        end
      Else
        InstalarBancoDeDados := True;
      end
    If InstalarPg83() Then
      DelTree(ExpandConstant('{pf}\PostgreSQL\8.3\data'), True, True, True);    
  end
  if  CurStep=ssPostInstall then
    begin
     
    end
end;

procedure CurUninstallStepChanged(CurUninstallStep: TUninstallStep);
begin
  If CurUninstallStep = usUninstall Then
  begin
    MsgBox(ExpandConstant('Atenção! Feche o {#MyAppName} antes de clicar em Ok caso ele esteja aberto.'), mbInformation, MB_OK);
    FecharBkpManager();
    DelTree(ExpandConstant('{app}\bin\jmf'), True, True, True);
  end
end;

function NeedsAddPath(Param: string): Boolean;
var
  OrigPath: string;
begin
  If Not RegQueryStringValue(HKEY_CURRENT_USER, 'Environment', 'CLASSPATH', OrigPath) Then
  begin
    Result := True;
    Exit;
  end;
  // look for the path with leading and trailing semicolon
  // Pos() returns 0 if not found
  Result := Pos(';' + UpperCase(ExpandConstant(Param)) + ';', ';' + UpperCase(OrigPath) + ';') = 0;  
  If Result = True Then
     Result := Pos(';' + UpperCase(ExpandConstant(Param)) + '\;', ';' + UpperCase(OrigPath) + ';') = 0; 
end;

function GetCustomSetupExitCode(): Integer;
begin  
  Result := 0;
end;

function GetDataDir(Param: String): String;
begin
  { Return the selected DataDir }
  Result := DataDirPage.Values[0];
end;

function NextButtonClick(CurPageID: Integer): Boolean;
begin
  // Set default folder if empty
  if DataDirPage.Values[0] = '' then
     DataDirPage.Values[0] := ExpandConstant('C:\{#MyAppName}\bd');
  Result := True;
end;

procedure InitializeWizard;
begin
  DataDirPage := CreateInputDirPage(wpSelectDir,
    'Pasta do banco de dados', 'Onde o banco de dados deve ser instalado?',
    'Escolha onde o banco de dados deve ser instalado, ou deixe em branco para usar o padrão, e clique em próximo. Instale em uma partição sem sistema operacional ou em um HD externo se possível.',
    False, '');
  DataDirPage.Add('');
          
  DataDirPage.Values[0] := GetPreviousData('DataDir', '');
end;