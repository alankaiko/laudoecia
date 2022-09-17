;Dados do programa
#define MyAppId "{{52488B4B-A2E3-455F-A9C7-76AE6DCBF105}"
#define MyAppName "LaudoeCia"
#define MyAppPublisher "J M De Paula Nova OpçãoMed-ME"
#define MyAppSite "http://www.laudoecia.com.br"
#define MyAppVersion "1.9.9.1"

;Arquivos e pastas
#define MyAppExe "LaudoeCia.jar"
#define MyAppBat "LaudoeCia.bat"
#define MyAppExeSemSplash "LaudoeCia-sem splash.jar"
#define NomeArquivoPcId "pc_id.lc"
#define PastaFerramentas "utils"
#define JavaVM "bin"
#define Resources "..\..\..\resources\setup\"
#define IsResources "is-resources\"

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
OutputBaseFilename={#MyAppName}-Terminal
OutputDir="..\..\..\dist"
PrivilegesRequired=admin
SetupIconFile={#Resources}{#IsResources}icone.ico
SolidCompression=yes
VersionInfoVersion={#MyAppVersion}
WizardImageFile={#Resources}{#IsResources}WizardImageFile.bmp
WizardSmallImageFile={#Resources}{#IsResources}WizardSmallImageFile.bmp

[Languages]
Name: "brazilianportuguese"; MessagesFile: "compiler:Languages\BrazilianPortuguese.isl"

[Tasks]
Name: quicklaunchicon; Description: {cm:CreateQuickLaunchIcon}; GroupDescription: {cm:AdditionalIcons}; OnlyBelowVersion: 0,6.1
Name: desktopicon; Description: {cm:CreateDesktopIcon}; GroupDescription: {cm:AdditionalIcons}

[Icons]
Name: {code:GrupoDoMenuIniciar}\Abrir o {#MyAppName}; Filename: {code:ExpandSrcFolder}\bin\{#MyAppName}.jar; IconFilename: {app}\bin\icone.ico; Comment: Clique para iniciar o {#MyAppName}; HotKey: "ctrl+alt+l"
Name: {code:GrupoDoMenuIniciar}\{cm:UninstallProgram,{#MyAppName}}; Filename: {uninstallexe}; Comment: Clique para desinstalar o {#MyAppName}
Name: {code:GrupoDoMenuIniciar}\Ferramentas; Filename: {code:ExpandSrcFolder}\{#PastaFerramentas}; Comment: Abre a pasta de ferramentas úteis ao {#MyAppName}; Flags: runmaximized
Name: {code:GrupoDoMenuIniciar}\Manual; Filename: {code:ExpandSrcFolder}\bin\help\index.html; Comment: Abre a ajuda do {#MyAppName}; Flags: runmaximized
Name: {code:GrupoDoMenuIniciar}\{#MyAppName} na internet; Filename: {#MyAppSite}; Flags: runmaximized
Name: {userdesktop}\{#MyAppName}; Filename: {app}\bin\LaudoeCia.bat; IconFilename: {app}\bin\icone.ico; Comment: Clique duas vezes para iniciar o {#MyAppName}; HotKey: "ctrl+l"; Tasks: desktopicon
Name: {userappdata}\Microsoft\Internet Explorer\Quick Launch\{#MyAppName}; Filename: {code:ExpandSrcFolder}\bin\{#MyAppBat}; IconFilename: {app}\bin\icone.ico; Comment: Clique para iniciar o {#MyAppName}; Tasks: quicklaunchicon

[Files]
Source: {#Resources}vm\*; DestDir: {app}\bin\vm; Flags: recursesubdirs
Source: {#Resources}JMF\DLLs\*; DestDir: {sys}
Source: {#Resources}JMF\JARs\*; DestDir: {app}\bin\lib
Source: {#Resources}{#IsResources}\icone.ico; DestDir: {app}\bin

[Registry]
Root: HKCU; Subkey: "Environment"; ValueType: expandsz; ValueName: "CLASSPATH"; ValueData: ".;{olddata}"; Check: NeedsAddPath('.')
Root: HKCU; Subkey: "Environment"; ValueType: expandsz; ValueName: "CLASSPATH"; ValueData: "{app}\bin\lib\jmf.jar;{olddata}"; Check: NeedsAddPath('{app}\bin\lib\jmf.jar')
Root: HKCU; Subkey: "Environment"; ValueType: expandsz; ValueName: "CLASSPATH"; ValueData: "{app}\bin\lib\sound.jar;{olddata}"; Check: NeedsAddPath('{app}\bin\lib\sound.jar')
Root: HKCU; Subkey: "Environment"; ValueType: expandsz; ValueName: "CLASSPATH"; ValueData: "{app}\bin\lib;{olddata}"; Check: NeedsAddPath('{app}\bin\lib')

[Run]
Filename: {app}\bin\vm\bin\javaw.exe; parameters: " -jar ""{code:ExpandSrcFolder}\bin\{#MyAppExeSemSplash}"" salvarEstacao"; Check: NaoEstaNoModoAtualizacao;
Filename: {app}\bin\LaudoeCia.bat; Description: {cm:LaunchProgram,{#StringChange(MyAppName, '&', '&&')}}; Flags: shellexec postinstall skipifsilent

[Code]

var
  ModoAtualizacao: Boolean;
  IconGroup: String;  

function ExpandSrcFolder(Param: String): String;
begin
  Result := ExpandConstant('{src}');
end;

function CreateBatchFile(): boolean;
var
  fileName : string;
  instDir : string;
  lines : TArrayOfString;
begin
  Result := true;
  instDir := ExpandConstant('start "" "{app}\bin\vm\bin\javaw.exe" -Xmx1024M -jar "{code:ExpandSrcFolder}\bin\LaudoeCia.jar"');
  fileName := ExpandConstant('{app}\bin\LaudoeCia.bat');
  SetArrayLength(lines, 1);
  lines[0] := instDir;
  Result := SaveStringsToFile(filename,lines,true);
  exit;
end;

function GrupoDoMenuIniciar(Param: String): String;
begin
  If ModoAtualizacao Then
    Result := ExpandConstant('{commonprograms}\' + IconGroup)
  Else
    Result := ExpandConstant('{group}');
end;



function InitializeSetup(): Boolean;
var
  LaudoeCiaEstaInstalado: Boolean;
  VersaoDoLaudoeCia: String;
begin
  ModoAtualizacao := False;
  IconGroup := ExpandConstant('{#MyAppName}');
  LaudoeCiaEstaInstalado := RegQueryStringValue(HKEY_LOCAL_MACHINE, ExpandConstant('SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall\{#MyAppId}_is1'), 'DisplayVersion', VersaoDoLaudoeCia);
  If LaudoeCiaEstaInstalado Then
    begin
    If (VersaoDoLaudoeCia = '1.0.0') Or (VersaoDoLaudoeCia = '1.0.1') Or (VersaoDoLaudoeCia = '1.0.2') Or (VersaoDoLaudoeCia = '1.1.0') Or (VersaoDoLaudoeCia = '1.1.1') Or (VersaoDoLaudoeCia = '1.2.0') Or (VersaoDoLaudoeCia = '1.3.0') Or (VersaoDoLaudoeCia = '1.3.1') Or (VersaoDoLaudoeCia = '1.4.0') Or (VersaoDoLaudoeCia = '1.5.0') Or (VersaoDoLaudoeCia = '1.6.0') Or (VersaoDoLaudoeCia = '1.7.0') Or (VersaoDoLaudoeCia = '1.8.0') Or (VersaoDoLaudoeCia = '1.9.0') Or (VersaoDoLaudoeCia = '1.9.1') Or (VersaoDoLaudoeCia = '1.9.2') Or (VersaoDoLaudoeCia = '1.9.3') Or (VersaoDoLaudoeCia = '1.9.4') Or (VersaoDoLaudoeCia = '1.9.4.1') Or (VersaoDoLaudoeCia = '1.9.4.2') Or (VersaoDoLaudoeCia = '1.9.4.3') Or (VersaoDoLaudoeCia = '1.9.4.4')  Or (VersaoDoLaudoeCia = '1.9.5') Or (VersaoDoLaudoeCia = '1.9.5.1') Or (VersaoDoLaudoeCia = '1.9.6') Or (VersaoDoLaudoeCia = '1.9.6.1') Or (VersaoDoLaudoeCia = '1.9.6.2') Or (VersaoDoLaudoeCia = '1.9.7.0') Then 
      begin
      Result := True;
      ModoAtualizacao := True;
      RegQueryStringValue(HKEY_LOCAL_MACHINE, ExpandConstant('SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall\{#MyAppId}_is1'), 'Inno Setup: Icon Group', IconGroup);
      end
    Else
      begin
      Result := False;
      MsgBox(ExpandConstant('Você já possui a versão mais recente do {#MyAppName}.'), mbInformation, MB_OK);
      end
    end    
  Else
    begin
    If (FileExists(ExpandConstant('{code:ExpandSrcFolder}\{#PastaFerramentas}/a'))) Then
      Result := False
   Else
      begin
      Result := True;
      end    
    end   
end;

function NaoEstaNoModoAtualizacao(): Boolean;
begin
  Result := Not ModoAtualizacao;
end;

procedure MoverArquivoPcId();
var
  Origem, Destino: String;
begin
  Origem := ExpandConstant('{code:ExpandSrcFolder}\bin\recursos\{#NomeArquivoPcId}');
  Destino := ExpandConstant('{sys}\{#NomeArquivoPcId}');
  FileCopy(Origem, Destino, True);
  DeleteFile(Origem);
end;

function NeedsAddPath(Param: String): Boolean;
var
  OrigPath: String;
begin
  If Not RegQueryStringValue(HKEY_CURRENT_USER, 'Environment', 'CLASSPATH', OrigPath) Then
  begin
    Result := True;
    Exit;
  end;
  // look for the path with leading and trailing semicolon
  // Pos() returns 0 if not found
  Result := Pos(';' + UpperCase(ExpandConstant(param)) + ';', ';' + UpperCase(OrigPath) + ';') = 0;  
  If Result = True Then
     Result := Pos(';' + UpperCase(ExpandConstant(param)) + '\;', ';' + UpperCase(OrigPath) + ';') = 0; 
end;

function GetCustomSetupExitCode() : Integer;
begin
  If ModoAtualizacao Then
    DeleteFile(ExpandConstant('{code:GrupoDoMenuIniciar}\{#MyAppName}.lnk'));
    CreateBatchFile();
  If Not ModoAtualizacao Then
    MoverArquivoPcId(); 
    CreateBatchFile(); 
  Result := 0;
end;                  