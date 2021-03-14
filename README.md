# JavaEksamen
JavaEksamen 2020
Eksamen OBJ2100 mai 2020

Du er på et team som skal begynne å bygge et lite system som kanskje andre skal fortsette
på. Derfor er det viktig at koden har god kvalitet, som høy kohesjon, lav kobling og
sterk innkapsling.

**Problemområde**
En vanlig datamaskin med et vanlig fil-system har som regel mange filer i docx-format spredt
på forskjellige steder i maskinens filsystem. Problemområdet for denne oppgaven er et lite
system som lar en bruker selv lete gjennom fil-systemet sitt for å finne docx-filer som skal
"huskes" av systemet. Systemet trenger ikke å skanne filsystemet for å finne docx-filer, men
det må huske søkesti og filnavn til alle filene brukeren har valgt, og den siste mappen der
brukeren valgte en fil. Det siste er for å la brukeren komme raskt tilbake til samme mappe
ved neste filvalg. Dette må skje også etter at systemet er stanset og startet på nytt. 
Systemet skal vise meta-informasjon fra docx-filer.

**Oppgave**
Det skal bygges et GUI i Java SE, versjon 8.x som kan la en bruker lagre søkesti og navn på
docx-filer. Teamet ditt velger layout selv, for eksempel ved å bruke JList eller JTable, eller
kanskje begge deler.
De docx-filene som er samlet av brukeren har som alle docx-filer en del kjerne-informasjon,
noen steder kalt "Core". Når brukeren peker på en av filene skal en del av denne
informasjonen vises, for eksempel vist slik som i denne illustrasjonen.
![image](https://user-images.githubusercontent.com/25333335/111079293-ada61d00-84f9-11eb-9fdc-8378e7edf469.png)

Her er det vist sju egenskaper, nemlig title, creator, created, modified, last modified by, last
printed og revision. Hvis en egenskap ikke har noen verdi, eller hvis en egenskap ikke finnes,
kan det for eksempel settes inn et spørsmålstegn. For eksempel er det slik at ikke alle macmaskiner produserer docx-filer med title-egenskapen.
Disse egenskapene kan finnes ved hjelp av tredjeparts open-source verktøy, som for
eksempel docx4j, eller ved å lese docx-filer som zip-filer, og deretter bruke xml-verktøy for å
finne de sju rette egenskapene.
Det GUI-et som er vist ovenfor, er bare et forslag til hvordan GUI-et kan bygges. Hvis
systemet bygges med høy kohesjon og lav kopling, skal det være enkelt for et annet team
senere å forbedre GUI-et, eller bygge et helt annet GUI.
