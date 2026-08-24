public class 7.14 {
   // 7.14

class Lista {
    constructor(tamano = 10) {
        this.tabla = new Array(tamano);
        this.numeroElementos = 0;
    }

    getNumeroElementos() {
        return this.numeroElementos;
    }

    insertarFinal(numero) {
        this.comprobarEspacio();
        this.tabla[this.numeroElementos] = numero;
        this.numeroElementos++;
    }

    eliminar(indice) {
        if (indice < 0 || indice >= this.numeroElementos) {
            return;
        }

        for (let i = indice; i < this.numeroElementos - 1; i++) {
            this.tabla[i] = this.tabla[i + 1];
        }

        this.numeroElementos--;
    }

    get(indice) {
        if (indice < 0 || indice >= this.numeroElementos) {
            return null;
        }

        return this.tabla[indice];
    }

    toString() {
        let texto = "";

        for (let i = 0; i < this.numeroElementos; i++) {
            texto = texto + this.tabla[i];

            if (i < this.numeroElementos - 1) {
                texto = texto + ", ";
            }
        }

        return texto;
    }

    comprobarEspacio() {
        if (this.numeroElementos == this.tabla.length) {
            let nuevaTabla = new Array(this.tabla.length * 2);

            for (let i = 0; i < this.numeroElementos; i++) {
                nuevaTabla[i] = this.tabla[i];
            }

            this.tabla = nuevaTabla;
        }
    }
}


// CLASE PILALISTA

class PilaLista {
    constructor() {
        this.lista = new Lista();
    }

    // Apilar
    apilar(numero) {
        this.lista.insertarFinal(numero);
    }

    // Desapilar
    desapilar() {
        if (this.estaVacia()) {
            return null;
        }

        let posicion = this.lista.getNumeroElementos() - 1;
        let numero = this.lista.get(posicion);

        this.lista.eliminar(posicion);

        return numero;
    }

    // Obtener la cima
    cima() {
        if (this.estaVacia()) {
            return null;
        }

        let posicion = this.lista.getNumeroElementos() - 1;

        return this.lista.get(posicion);
    }

    // Comprobar si está vacía
    estaVacia() {
        return this.lista.getNumeroElementos() == 0;
    }

    // Mostrar la pila
    toString() {
        return this.lista.toString();
    }
}


// PROGRAMA PRINCIPAL

let pila = new PilaLista();

pila.apilar(10);
pila.apilar(20);
pila.apilar(30);

console.log("Pila: " + pila.toString());

console.log("Cima: " + pila.cima());

console.log("Desapilamos: " + pila.desapilar());

console.log("Pila después de desapilar:");
console.log(pila.toString());

console.log("Cima: " + pila.cima()); 
}
