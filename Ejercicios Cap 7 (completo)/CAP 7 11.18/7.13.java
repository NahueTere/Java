
// 7.13

class PilaTabla {
    constructor() {
        this.tabla = [];
        this.numeroElementos = 0;
    }

    // Apilar un elemento
    apilar(numero) {
        this.tabla[this.numeroElementos] = numero;
        this.numeroElementos++;
    }

    // Desapilar el último elemento
    desapilar() {
        if (this.numeroElementos == 0) {
            return null;
        }

        this.numeroElementos--;

        let elemento = this.tabla[this.numeroElementos];

        return elemento;
    }

    // Obtener la cima de la pila
    cima() {
        if (this.numeroElementos == 0) {
            return null;
        }

        return this.tabla[this.numeroElementos - 1];
    }

    // Saber si la pila está vacía
    estaVacia() {
        return this.numeroElementos == 0;
    }

    // Obtener el número de elementos
    getNumeroElementos() {
        return this.numeroElementos;
    }

    // Mostrar la pila
    toString() {
        let texto = "";

        for (let i = this.numeroElementos - 1; i >= 0; i--) {
            texto = texto + this.tabla[i] + " ";
        }

        return texto;
    }
}


// PROGRAMA PRINCIPAL

let pila = new PilaTabla();

pila.apilar(10);
pila.apilar(20);
pila.apilar(30);

console.log("Pila: " + pila.toString());

console.log("Cima: " + pila.cima());

console.log("Desapilamos: " + pila.desapilar());

console.log("Pila después de desapilar:");
console.log(pila.toString());

console.log("Cima: " + pila.cima());

console.log("Cantidad de elementos: " + pila.getNumeroElementos());