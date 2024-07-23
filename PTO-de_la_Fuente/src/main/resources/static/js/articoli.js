const table = document.getElementById('articoli');
const url = 'http://localhost:8081/articoli';

fetch(url)
    .then((response) => {
        return response.json();
    })
    .then((data) => {
        let articoli = data;

        articoli.map(
            function(articolo) {
                aggiungi_tabella(
                    `${articolo.id}`,
                    `${articolo.codice}`,
                    `${articolo.descrizione}`,
                    `${articolo.peso}`);
            });
    })
    .catch(function(error) {
        console.log(error);
    });

function aggiungi_tabella(id_articolo,codice_articolo,descrizione_articolo,peso_articolo){

    let tr = document.createElement('tr');
    let id = document.createElement('td');
    let codice = document.createElement('td');
    let descrizione = document.createElement('td');
    let peso = document.createElement('td');

    id.innerHTML = id_articolo;
    codice.innerHTML = codice_articolo;
    descrizione.innerHTML = descrizione_articolo;
    peso.innerHTML = peso_articolo;

    tr.appendChild(id);
    tr.appendChild(codice);
    tr.appendChild(descrizione);
    tr.appendChild(peso);
    table.appendChild(tr);

}
