function getUrlVars()
{
    var vars = [], hash;
    var pos = location.search.indexOf('?');
    var hashes = pos == -1 ? [] : unescape(location.search).slice(pos + 1).split('&');

    for(var i = 0; i < hashes.length; i++)
    {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }

    return vars;
}

function retira_acentos(palavra) {
    com_acento = 'áàãâäéèêëíìîïóòõôöúùûüçÁÀÃÂÄÉÈÊËÍÌÎÏÓÒÕÖÔÚÙÛÜÇ';
    sem_acento = 'aaaaaeeeeiiiiooooouuuucAAAAAEEEEIIIIOOOOOUUUUC';
    nova='';
    for(var i = 0; i < palavra.length; i++) {
        if (com_acento.search(palavra.substr(i,1)) >= 0) {
            nova+=sem_acento.substr(com_acento.search(palavra.substr(i,1)),1);
        }
        else {
            nova+=palavra.substr(i,1);
        }
    }
    return nova;
}

function retira_conjuncoes(keywords)
{
    var conjuncoesARemover = Array ('e', 'do', 'da', 'de', 'dos', 'das', 'o', 'a', 'os', 'as', 'no', 'na', 'em', 'com', 'por', 'para');
    for (i = 0; i < keywords.length; i++) {
        for (j = 0; j < conjuncoesARemover.length; j++) {
            if (keywords[i] == conjuncoesARemover[j])
            {
                keywords.splice(i, 1);
                i--;
                break;
            }
        }
    }
    return keywords;
}

function retira_caracteres_especiais (text)
{
    return text.replace(/\^|~|\?|,|\*|\(|\)|\-/g, '').replace(/\s{2,}/g, ' ');
}

function titlePane(title, content, borderColor, titleFontColor, backgroundColor, fontColor)
{
    if (borderColor == null) borderColor = '#FFCC00';
    if (titleFontColor == null) titleFontColor = '#000000';
    if (backgroundColor == null) backgroundColor = '#FFFFDD';
    if (fontColor == null) fontColor = '#444444';

    var html = '<div style="font-size:11px; color:' + fontColor + '; border:1px solid ' + borderColor + '; padding:8px; padding-top:12px; background:' + backgroundColor + '; position:relative;" align="justify">';
    html += '<span style="position:absolute; top: -8px; color:' + titleFontColor + '; background:' + borderColor + ';"><b>&nbsp;' + title + '&nbsp;</b></span>';
    html += content;
    html += '</div>';

    document.write(html);
}
