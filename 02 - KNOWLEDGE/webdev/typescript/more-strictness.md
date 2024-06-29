
## Strict Mode

Para obtener la máxima rigurosidad en la verificación de tipos en TypeScript, puedes habilitar el modo estricto en tu archivo de configuración `tsconfig.json`. [El modo estricto es una opción de compilador que habilita una amplia gama de comportamientos de verificación de tipos que resultan en garantías más fuertes de corrección del programa](https://www.typescriptlang.org/tsconfig/strict.html)[1](https://www.typescriptlang.org/tsconfig/strict.html).

Para habilitar el modo estricto, debes agregar la opción `"strict": true` a la sección `"compilerOptions"` de tu archivo `tsconfig.json`[1](https://www.typescriptlang.org/tsconfig/strict.html). Por ejemplo:

```json
{
  "compilerOptions": {
    "strict": true
  }
}
```

Copy

[Habilitar el modo estricto es equivalente a habilitar todas las opciones de la familia del modo estricto, que se describen a continuación](https://www.typescriptlang.org/tsconfig/strict.html)[1](https://www.typescriptlang.org/tsconfig/strict.html). Puedes desactivar individualmente las comprobaciones de la familia del modo estricto según sea necesario[1](https://www.typescriptlang.org/tsconfig/strict.html). [Las versiones futuras de TypeScript pueden introducir comprobaciones más estrictas bajo esta opción, por lo que las actualizaciones de TypeScript pueden resultar en nuevos errores de tipo en tu programa](https://www.typescriptlang.org/tsconfig/strict.html)[1](https://www.typescriptlang.org/tsconfig/strict.html). [Cuando sea apropiado y posible, se agregará una opción correspondiente para deshabilitar ese comportamiento](https://www.typescriptlang.org/tsconfig/strict.html)[1](https://www.typescriptlang.org/tsconfig/strict.html).

Las opciones de la familia del modo estricto son las siguientes:

- `noImplicitAny`: Asegura que no puedas usar simplemente “JavaScript”, te obliga a usar "TypeScript"[2](https://dev.to/jsdev/strict-mode-typescript-j8p).
- [`noImplicitThis`: Con esta opción, no puedes usar `this` directamente dentro de una función](https://dev.to/jsdev/strict-mode-typescript-j8p)[2](https://dev.to/jsdev/strict-mode-typescript-j8p).
- `alwaysStrict`: Hace que cada archivo `.js` compilado tenga `"use strict";` como primera línea[2](https://dev.to/jsdev/strict-mode-typescript-j8p).
- `strictBindCallApply`: Mejora la verificación de tipos para las funciones `bind`, `call` y `apply`[2](https://dev.to/jsdev/strict-mode-typescript-j8p).
- `strictNullChecks`: Habilita comprobaciones más estrictas para valores nulos y undefined[2](https://dev.to/jsdev/strict-mode-typescript-j8p).
- `strictFunctionTypes`: Habilita comprobaciones más estrictas para la asignación de tipos de función[2](https://dev.to/jsdev/strict-mode-typescript-j8p).
- `strictPropertyInitialization`: Asegura que las propiedades de clase se inicialicen correctamente en el constructor[2](https://dev.to/jsdev/strict-mode-typescript-j8p).

Habilitar el modo estricto puede ayudarte a detectar errores y problemas en tu código antes de tiempo y te ayudará a aprender TypeScript con mayor rigor. ¿Te gustaría más información sobre esto? 😊


```json
// strickness
        "strict": true,
        "noUncheckedIndexedAccess": true,
        "noImplicitAny": true,
        "alwaysStrict": true,
        "strictBindCallApply": true,
        "strictNullChecks": true,
        "strictFunctionTypes": true,
        "strictPropertyInitialization": true,
```

