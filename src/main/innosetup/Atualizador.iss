;Dados do programa
#define MyAppId "{{06D4709A-A7BE-4EE0-BBE6-D3BD28D2FF21}"
#define MyAppName "LaudoeCia"
#define MyAppPublisher "J M De Paula Nova OpçãoMed-ME"
#define MyAppSite "http://www.laudoecia.com.br"
#define MyAppVersion "1.9.9.1"       

;Database
#define DatabaseSuperUser "teknamed"

;Arquivos
#define MyAppExe "LaudoeCia.jar"
#define MyAppBat "LaudoeCia.bat"
#define MyAppExeSemSplash "LaudoeCia-sem splash.jar"
#define PastaFerramentas "utils"
#define Resources "..\..\..\resources\setup\"
#define IsResources "is-resources\"
#define Dist "..\..\..\target\dist\" 
#define OutputDir "..\..\..\dist"

;Configurações
#define AcessoRemotoSite "http://www.teamviewer.com/pt"
#define PdfSite "http://www.tracker-software.com/product/pdf-xchange-viewer"

[Setup]
AppId={#MyAppId}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
AppPublisher={#MyAppPublisher}
ChangesEnvironment=yes
Compression=lzma
DefaultDirName={pf}\{#MyAppName}
DefaultGroupName={#MyAppName}
DisableDirPage=auto
DisableProgramGroupPage=auto
LicenseFile={#Resources}{#IsResources}licenca.txt
OutputBaseFilename={#MyAppName}-Atualizador
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
Source: {#Dist}lib\CompanyLibrary.jar; DestDir: {app}\bin\lib; 
Source: {#Dist}lib\bcprov-ext-jdk15on-152.jar; DestDir: {app}\bin\lib; Flags: onlyifdoesntexist
Source: {#Dist}lib\bcprov-jdk15on-152.jar; DestDir: {app}\bin\lib; Flags: onlyifdoesntexist
Source: {#Dist}lib\org.eclipse.persistence.*.jar; DestDir: {app}\bin\lib; Flags: onlyifdoesntexist
Source: {#Dist}lib\javax.persistence-2.0.5.jar; DestDir: {app}\bin\lib; Flags: onlyifdoesntexist
Source: {#Dist}*.jar; DestDir: {app}\bin;
Source: {#Dist}recursos\bkpRestore.backup; DestDir: {app}\bin\recursos
Source: {#Dist}help\*; DestDir: {app}\bin\help; Flags: recursesubdirs createallsubdirs

Source: {#Resources}TeamViewer\TeamViewerQS_pt.exe; DestDir: {app}\{#PastaFerramentas}
Source: {#Resources}vm\*; DestDir: {app}\bin\vm; Flags: recursesubdirs
Source: {#OutputDir}\{#MyAppName}-Terminal.exe; DestDir: {app}; DestName: {#MyAppName} - Terminal.exe 

[Icons]
Name: {code:GrupoDoMenuIniciar}\Abrir o {#MyAppName}; Filename: {app}\bin\{#MyAppBat}; IconFilename: {app}\bin\icone.ico; Comment: Clique para iniciar o {#MyAppName}; HotKey: "ctrl+alt+l"
Name: {code:GrupoDoMenuIniciar}\{cm:UninstallProgram,{#MyAppName}}; Filename: {uninstallexe}; Comment: Clique para desinstalar o {#MyAppName}
Name: {code:GrupoDoMenuIniciar}\Ferramentas; Filename: {app}\{#PastaFerramentas}; Comment: Abre a pasta de ferramentas úteis ao {#MyAppName}; Flags: runmaximized
Name: {code:GrupoDoMenuIniciar}\Manual; Filename: {app}\bin\help\index.html; Comment: Abre o manual do {#MyAppName}; Flags: runmaximized
Name: {code:GrupoDoMenuIniciar}\{#MyAppName} na internet; Filename: {#MyAppSite}; Flags: runmaximized              
Name: {userdesktop}\{#MyAppName}; Filename: {app}\bin\LaudoeCia.bat; WorkingDir: {app}\bin; IconFilename: {app}\bin\icone.ico; IconIndex: 0; Flags: closeonexit createonlyiffileexists; Comment: Clique duas vezes para iniciar o {#MyAppName}; Tasks: desktopicon
Name: {userdesktop}\Suporte remoto; Filename: {app}\{#PastaFerramentas}\TeamViewerQS_pt.exe; WorkingDir: {app}\{#PastaFerramentas}; IconFilename: {app}\{#PastaFerramentas}\TeamViewerQS_pt.exe; IconIndex: 0; Flags: closeonexit createonlyiffileexists; Comment: Clique duas vezes para iniciar o suporte remoto; Tasks: desktopicon

[Run]
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizador"; StatusMsg: Atualizando descrição da versão
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.0.0"; StatusMsg: Atualizando banco de dados (1.0.0); Check: AtualizarV1_0_0
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.0.1"; StatusMsg: Atualizando banco de dados (1.0.1); Check: AtualizarV1_0_1
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.0.2"; StatusMsg: Atualizando banco de dados (1.0.2); Check: AtualizarV1_0_2
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.2.0"; StatusMsg: Atualizando banco de dados (1.2.0); Check: AtualizarV1_2_0
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.3.0"; StatusMsg: Atualizando banco de dados (1.3.0); Check: AtualizarV1_3_0
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.3.1"; StatusMsg: Atualizando banco de dados (1.3.1); Check: AtualizarV1_3_1
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.4.0"; StatusMsg: Atualizando banco de dados (1.4.0); Check: AtualizarV1_4_0
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.6.0"; StatusMsg: Atualizando banco de dados (1.6.0); Check: AtualizarV1_6_0
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.7.0"; StatusMsg: Atualizando banco de dados (1.7.0); Check: AtualizarV1_7_0
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.8.0"; StatusMsg: Atualizando banco de dados (1.8.0); Check: AtualizarV1_8_0
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.9.1"; StatusMsg: Atualizando banco de dados (1.9.1); Check: AtualizarV1_9_1
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.9.2"; StatusMsg: Atualizando banco de dados (1.9.2); Check: AtualizarV1_9_2
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.9.3"; StatusMsg: Atualizando banco de dados (1.9.3); Check: AtualizarV1_9_3
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.9.4"; StatusMsg: Atualizando banco de dados (1.9.4); Check: AtualizarV1_9_4
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.9.4.1"; StatusMsg: Atualizando banco de dados (1.9.4.1); Check: AtualizarV1_9_4_1
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.9.4.2"; StatusMsg: Atualizando banco de dados (1.9.4.2); Check: AtualizarV1_9_4_2
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.9.4.3"; StatusMsg: Atualizando banco de dados (1.9.4.3); Check: AtualizarV1_9_4_2
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.9.4.4"; StatusMsg: Atualizando banco de dados (1.9.4.4); Check: AtualizarV1_9_4_3
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.9.5"; StatusMsg: Atualizando banco de dados (1.9.5); Check: AtualizarV1_9_5
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" atualizadorV1.9.6"; StatusMsg: Atualizando banco de dados (1.9.6); Check: AtualizarV1_9_6

Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" laudos"; StatusMsg: Atualizando modelos de laudos; 
Filename: {app}\bin\vm\bin\javaw.exe; Parameters: " -jar ""{app}\bin\{#MyAppExeSemSplash}"" backup"; Flags: nowait
Filename: {app}\bin\{#MyAppExe}; Description: {cm:LaunchProgram,{#StringChange(MyAppName, '&', '&&')}}; Flags: shellexec postinstall skipifsilent

[Code]

var
  IconGroup: String;
  VersaoDoLaudoeCia: String;

procedure FecharBkpManager();
var
  ResultCode: Integer;
begin
  Exec(ExpandConstant('{app}\bin\vm\bin\javaw.exe'), ExpandConstant(' -jar "{app}\bin\{#MyAppExeSemSplash}" fecharbkpmanager'), '', SW_SHOW, ewWaitUntilTerminated, ResultCode);  
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

procedure FecharBkpManager1_0_0();
var
  ResultCode: Integer;
begin
  Exec(ExpandConstant('{app}\bin\vm\bin\javaw.exe'), ExpandConstant(' -jar "{app}\bin\{#MyAppExeSemSplash}" desinstalador'), '', SW_SHOW, ewWaitUntilTerminated, ResultCode);  
end;

function JreEstaInstalada(): Boolean;
var
  VersaoDoJava: String;
begin
  Result := False;
  If RegQueryStringValue(HKEY_LOCAL_MACHINE, 'SOFTWARE\JavaSoft\Java Runtime Environment', 'CurrentVersion', VersaoDoJava) Then
  begin
   If VersaoDoJava = '1.7' Then
      Result := True;
    If VersaoDoJava = '1.8' Then
      Result := True;
  end     
end;

function JreNaoEstaInstalada(): Boolean;
var
  VersaoDoJava: String;
begin
  Result := True;
  If RegQueryStringValue(HKEY_LOCAL_MACHINE, 'SOFTWARE\JavaSoft\Java Runtime Environment', 'CurrentVersion', VersaoDoJava) Then
  begin
    If VersaoDoJava = '1.8' Then
      Result := False;
  end     
end;

function BdLcEstaInstalado(): Boolean;
var
  ResultStr: String;
  Pg82EstaInstal: Boolean;
  Pg82LcEstaInstal: Boolean;
  Pg83EstaInstal: Boolean;
  Pg83LcEstaInstal: Boolean;
begin
    Pg83EstaInstal := RegQueryStringValue(HKEY_LOCAL_MACHINE, 'SOFTWARE\PostgreSQL\Installations\{B823632F-3B72-4514-8861-B961CE263224}', 'Version', ResultStr);
    Pg82EstaInstal := RegQueryStringValue(HKEY_LOCAL_MACHINE, 'SOFTWARE\PostgreSQL\Installations\{1F701DBD-1660-4108-B10A-FB435EA63BF0}', 'Version', ResultStr);
    If Pg83EstaInstal And RegQueryStringValue(HKEY_LOCAL_MACHINE, 'SOFTWARE\PostgreSQL\Services\pgsql-8.3', 'Database Superuser', ResultStr) Then
      Pg83LcEstaInstal := (ResultStr = '{#DatabaseSuperUser}')
    Else 
      Pg83LcEstaInstal := False;
    If Pg82EstaInstal And RegQueryStringValue(HKEY_LOCAL_MACHINE, 'SOFTWARE\PostgreSQL\Services\pgsql-8.2', 'Database Superuser', ResultStr) Then
      Pg82LcEstaInstal := (ResultStr = '{#DatabaseSuperUser}')
    Else 
      Pg82LcEstaInstal := False; 
    Result := Pg83LcEstaInstal Or Pg82LcEstaInstal;      
end;
  
function InitializeSetup(): Boolean;
var
  LaudoeCiaEstaInstalado: Boolean;  
begin  
  Result := False;
  LaudoeCiaEstaInstalado := RegQueryStringValue(HKEY_LOCAL_MACHINE, ExpandConstant('SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall\{#MyAppId}_is1'), 'DisplayVersion', VersaoDoLaudoeCia);
  CreateBatchFileStart();
  If LaudoeCiaEstaInstalado Then
    begin
    If (VersaoDoLaudoeCia = '1.3.0') Or (VersaoDoLaudoeCia = '1.3.1') Or (VersaoDoLaudoeCia = '1.4.0') Or (VersaoDoLaudoeCia = '1.5.0') Or (VersaoDoLaudoeCia = '1.6.0') Or (VersaoDoLaudoeCia = '1.7.0') Or (VersaoDoLaudoeCia = '1.8.0') Or (VersaoDoLaudoeCia = '1.9.0') Or (VersaoDoLaudoeCia = '1.9.1') Or (VersaoDoLaudoeCia = '1.9.2') Or (VersaoDoLaudoeCia = '1.9.3') Or (VersaoDoLaudoeCia = '1.9.4') Or (VersaoDoLaudoeCia = '1.9.4.1') Or (VersaoDoLaudoeCia = '1.9.4.2') Or (VersaoDoLaudoeCia = '1.9.4.3') Or (VersaoDoLaudoeCia = '1.9.4.4') Or (VersaoDoLaudoeCia = '1.9.5') Or (VersaoDoLaudoeCia = '1.9.5.1') Or (VersaoDoLaudoeCia = '1.9.6') Or (VersaoDoLaudoeCia = '1.9.6.1') Or (VersaoDoLaudoeCia = '1.9.6.2') Or (VersaoDoLaudoeCia = '1.9.7.0') Or (VersaoDoLaudoeCia = '1.9.8.0') Or (VersaoDoLaudoeCia = '1.9.9.0') Then Begin      
      If Not JreEstaInstalada() Then Begin
        MsgBox(ExpandConstant('A instalação está corrompida, pois o Java não está instalado. Contate o suporte técnico.'), mbInformation, MB_OK);
      End Else If Not BdLcEstaInstalado() Then Begin
        MsgBox(ExpandConstant('A instalação está corrompida, pois o banco de dados não está instalado. Contate o suporte técnico.'), mbInformation, MB_OK);
      End Else
        begin
        Result := True;
        IconGroup := ExpandConstant('{#MyAppName}');
        RegQueryStringValue(HKEY_LOCAL_MACHINE, ExpandConstant('SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall\{#MyAppId}_is1'), 'Inno Setup: Icon Group', IconGroup); 
        end       
    End Else If (VersaoDoLaudoeCia = '1.0.0') Or (VersaoDoLaudoeCia = '1.0.1') Or (VersaoDoLaudoeCia = '1.0.2') Or (VersaoDoLaudoeCia = '1.1.0') Or (VersaoDoLaudoeCia = '1.1.1') Or (VersaoDoLaudoeCia = '1.2.0') Then Begin
        MsgBox(ExpandConstant('A versão instalada não pode ser atualizada. Contate o suporte técnico.'), mbInformation, MB_OK);
    End Else
      begin
        MsgBox(ExpandConstant('Você já possui a versão mais recente do {#MyAppName}.'), mbInformation, MB_OK);      
      end
    end    
  Else
    MsgBox(ExpandConstant('Você não possui o {#MyAppName} instalado no seu computador. Baixe o instalador no site.'), mbInformation, MB_OK);    
end;

function AtualizarV1_0_0(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.0.0');
end;

function AtualizarV1_0_1(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.0.1') Or AtualizarV1_0_0();
end;

function AtualizarV1_0_2(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.0.2') Or AtualizarV1_0_1();
end;

function AtualizarV1_1_0(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.1.0') Or AtualizarV1_0_2();
end;

function AtualizarV1_2_0(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.2.0') Or AtualizarV1_1_0();
end;

function AtualizarV1_3_0(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.3.0') Or AtualizarV1_2_0();
end;

function AtualizarV1_3_1(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.3.1') Or AtualizarV1_3_0();
end;

function AtualizarV1_4_0(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.4.0') Or AtualizarV1_3_1();
end;

function AtualizarV1_5_0(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.5.0') Or AtualizarV1_4_0();
end;

function AtualizarV1_6_0(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.6.0') Or AtualizarV1_5_0();
end;

function AtualizarV1_7_0(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.7.0') Or AtualizarV1_6_0();
end;

function AtualizarV1_8_0(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.8.0') Or AtualizarV1_7_0();
end;

function AtualizarV1_9_0(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.9.0') Or AtualizarV1_8_0();
end;

function AtualizarV1_9_1(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.9.1') Or AtualizarV1_9_0();
end;

function AtualizarV1_9_2(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.9.2') Or AtualizarV1_9_1();
end;

function AtualizarV1_9_3(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.9.3') Or AtualizarV1_9_2();
end;

function AtualizarV1_9_4(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.9.4') Or AtualizarV1_9_3();
end;

function AtualizarV1_9_4_1(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.9.4.1') Or AtualizarV1_9_4();
end;

function AtualizarV1_9_4_2(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.9.4.2') Or AtualizarV1_9_4_1();
end;

function AtualizarV1_9_4_3(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.9.4.3') Or AtualizarV1_9_4_2();
end;

function AtualizarV1_9_4_4(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.9.4.4') Or AtualizarV1_9_4_3();
end;

function AtualizarV1_9_5(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.9.5') Or AtualizarV1_9_4_4();
end;

function AtualizarV1_9_6(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.9.6') Or AtualizarV1_9_5();
end;

function AtualizarV1_9_6_1(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.9.6.1') Or AtualizarV1_9_6();
end;

function AtualizarV1_9_6_2(): Boolean;
begin
  Result := (VersaoDoLaudoeCia = '1.9.6.2') Or AtualizarV1_9_6_1();
end;

function GrupoDoMenuIniciar(Param: String): String;
begin
  Result := ExpandConstant('{commonprograms}\' + IconGroup)
end;

procedure CurStepChanged(CurStep: TSetupStep);
begin
  If CurStep = ssInstall Then
  begin 
    MsgBox(ExpandConstant('Atenção! Feche o {#MyAppName} caso ele esteja aberto para atualizar para a versão {#MyAppVersion}.'), mbInformation, MB_OK);
    If VersaoDoLaudoeCia = '1.0.0' Then
      FecharBkpManager1_0_0()
    Else
      FecharBkpManager(); 
    If AtualizarV1_9_6_2() Then
    begin
    DeleteFile(ExpandConstant('{app}\bin\lib\CompanyLibrary-1.0.2.jar'));
    DeleteFile(ExpandConstant('{app}\bin\lib\CompanyLibrary-1.0.1.jar'));
    DeleteFile(ExpandConstant('{app}\bin\lib\CompanyLibrary-1.0.0.jar'));
    DeleteFile(ExpandConstant('{app}\bin\lib\javax.persistence_2.0.3.v201010191057.jar'));
    DeleteFile(ExpandConstant('{app}\bin\lib\eclipselink.jar'));
    end                     
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

function GetCustomSetupExitCode(): Integer;
begin
  If (VersaoDoLaudoeCia = '1.0.0') Then
    DeleteFile(ExpandConstant('{code:GrupoDoMenuIniciar}\{#MyAppName}.lnk'));  
  Result := 0;
end;