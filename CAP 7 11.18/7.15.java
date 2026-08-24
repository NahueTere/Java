public class 7.15 {
    // 7.15

class ColaTabla {
    constructor() {
        this.tabla = [];
        this.numeroElementos = 0;
    }

    // Encolar un número
    encolar(numero) {
        this.tabla[this.numeroElementos] = numero;
        this.numeroElementos++;
    }

    // Desencolar el primer número
    desencolar() {
        if (this.numeroElementos == 0) {
            return null;
        }

        let numero = this.tabla[0];

        // Movemos todos los elementos una posición hacia la izquierda
        for (let i = 0; i < this.numeroElementos - 1; i++) {
            this.tabla[i] = this.tabla[i + 1];
        }

        this.numeroElementos--;

        return numero;
    }

    // Obtener el primer elemento
    primero() {
        if (this.numeroElementos == 0) {
            return null;
        }

        return this.tabla[0];
    }

    // Obtener el último elemento
    ultimo() {
        if (this.numeroElementos == 0) {
            return null;
        }

        return this.tabla[this.numeroElementos - 1];
    }

    // Comprobar si la cola está vacía
    estaVacia() {
        return this.numeroElementos == 0;
    }

    // Obtener el número de elementos
    getNumeroElementos() {
        return this.numeroElementos;
    }

    // Mostrar la cola
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
}


// PROGRAMA PRINCIPAL

let cola = new ColaTabla();

cola.encolar(10);
cola.encolar(20);
cola.encolar(30);

console.log("Cola: " + cola.toString());

console.log("Primero: " + cola.primero());

console.log("Último: " + cola.ultimo());

console.log("Desencolamos: " + cola.desencolar());

console.log("Cola después de desencolar:");
console.log(cola.toString());

console.log("Primero: " + cola.primero());

console.log("Último: " + cola.ultimo());
}
