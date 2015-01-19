<?php
extract($_POST);


$fname ="test.xml";
$nfile = fopen($fname,"r");
if(!$nfile)
{
	//Construction de la racine quand le fichier n'existe pas
	$racine = new SimpleXMLElement("<films></films>");
}
else
{
	$racine = simplexml_load_file($fname); //Lecture de la racine comme un élément XML
}

$film = $racine->addChild("film");
$film->addAttribute("annee",$annee);
$film->addChild("titre",$titre);
$img= $film->addChild("image");
$img->addAttribute("adresse",$adresse);

$film->addChild("realisateur",$realisateur);
fclose($nfile);
$nfile=fopen($fname,"w");
fwrite($nfile,$racine->asXML());
echo "$acteurs";
?>