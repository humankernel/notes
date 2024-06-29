
| Selector | Description | Example |
| --- | --- | --- |
| Universal `*`  | Selects all elements.  | `* {color: red;}` |
| Class `.class`  | Selects all elements with a specific class.  | `.intro {font-size: 24px;}`|
| ID `#id` 	| Selects an element with a specific ID. 	| `#myID {background-color: yellow;}`|
| Attribute `[attribute]` 	| Selects elements with a specific attribute. 	| `[target=_blank] {color: blue;}`|
| Descendant `A B` 	| Selects elements that are descendants of another element. 	| `div p {color: green;}`|
| Child `A > B`  	| Select direct children of an element  	| A > B selects all B that are a direct children A |
| Adjacent sibling `A + B`  	| Select the next sibling element of another element  	| h1 + p selects the first p element after h1 |
| General sibling `A ~ B`  	| Select all following sibling elements of another element  	| h1 ~ p selects all p elements after h1 |
| Grouping `A, B`  | Selects multiple elements.  | `h1, h2, h3 {color: purple;}` |


## Pseudo Selectors

| Selector | Description | Example |
| --- | --- | --- |
| Pseudoclase `:pseudo-class`  | Selects elements in a specific state.  | `a:hover {color: red;}` |
| Pseudoelemento `::pseudo-element`  | Selects a specific part of an element.  | `p::first-line {font-weight: bold;}`|

Los selectores de pseudoclase te permiten seleccionar elementos en un estado específico, como cuando un enlace es visitado (`:visited`) o cuando el usuario pasa el cursor sobre un elemento (`:hover`). Los selectores de pseudoelemento te permiten seleccionar una parte específica de un elemento, como la primera línea de un párrafo (`::first-line`) o el contenido generado antes o después de un elemento (`::before` y `::after`).


First Child Pseudo-selector
Only Child Pseudo-selector