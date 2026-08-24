public class 7.17 {
   // 7.17

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

    buscar(numero) {
        for (let i = 0; i < this.numeroElementos; i++) {
            if (this.tabla[i] == numero) {
                return i;
            }
        }

        return -1;
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


// CLASE CONJUNTO

class Conjunto {
    constructor(tamano = 10) {
        this.lista = new Lista(tamano);
    }

    // Obtener número de elementos
    getNumeroElementos() {
        return this.lista.getNumeroElementos();
    }

    // Insertar un número
    insertar(numero) {
        // Solo se inserta si no existe
        if (!this.pertenece(numero)) {
            this.lista.insertarFinal(numero);
        }
    }

    // Añadir los elementos de otro conjunto
    insertarConjunto(conjunto) {
        for (let i = 0; i < conjunto.getNumeroElementos(); i++) {
            this.insertar(conjunto.get(i));
        }
    }

    // Obtener un elemento
    get(indice) {
        return this.lista.get(indice);
    }

    // Eliminar un elemento
    eliminar(numero) {
        let posicion = this.lista.buscar(numero);

        if (posicion != -1) {
            this.lista.eliminar(posicion);
        }
    }

    // Eliminar los elementos de otro conjunto
    eliminarConjunto(conjunto) {
        for (let i = 0; i < conjunto.getNumeroElementos(); i++) {
            this.eliminar(conjunto.get(i));
        }
    }

    // Comprobar si pertenece al conjunto
    pertenece(numero) {
        return this.lista.buscar(numero) != -1;
    }

    // Mostrar el conjunto
    toString() {
        return "{" + this.lista.toString() + "}";
    }
}


// PROGRAMA PRINCIPAL

let conjunto1 = new Conjunto();

conjunto1.insertar(10);
conjunto1.insertar(20);
conjunto1.insertar(30);

console.log("Conjunto: " + conjunto1.toString());


// Intentamos insertar un número repetido
conjunto1.insertar(20);

console.log("Después de insertar 20 otra vez:");
console.log(conjunto1.toString());


// Comprobar si pertenece
console.log("¿Pertenece 10? " + conjunto1.pertenece(10));
console.log("¿Pertenece 50? " + conjunto1.pertenece(50));


// Eliminar un elemento
conjunto1.eliminar(20);

console.log("Después de eliminar 20:");
console.log(conjunto1.toString());


// Crear otro conjunto
let conjunto2 = new Conjunto();

conjunto2.insertar(30);
conjunto2.insertar(40);
conjunto2.insertar(50);

console.log("Conjunto 2: " + conjunto2.toString());


// Añadir conjunto2 a conjunto1
conjunto1.insertarConjunto(conjunto2);

console.log("Después de añadir conjunto2:");
console.log(conjunto1.toString());


// Eliminar los elementos de conjunto2
conjunto1.eliminarConjunto(conjunto2);

console.log("Después de eliminar los elementos de conjunto2:");
console.log(conjunto1.toString()); 
}
