To access memory we can use these four registers: **BX, SI, DI, BP**.

Combining these registers inside **[ ]** symbols, we can get different memory locations.

These combinations are supported (addressing modes):

|                                                        |                                                                                |                                                                            |
| ------------------------------------------------------ | ------------------------------------------------------------------------------ | -------------------------------------------------------------------------- |
| [BX + SI]  <br>[BX + DI]  <br>[BP + SI]  <br>[BP + DI] | [SI]  <br>[DI]  <br>d16 (variable offset only)  <br>[BX]                       | [BX + SI + d8]  <br>[BX + DI + d8]  <br>[BP + SI + d8]  <br>[BP + DI + d8] |
| [SI + d8]  <br>[DI + d8]  <br>[BP + d8]  <br>[BX + d8] | [BX + SI + d16]  <br>[BX + DI + d16]  <br>[BP + SI + d16]  <br>[BP + DI + d16] | [SI + d16]  <br>[DI + d16]  <br>[BP + d16]  <br>[BX + d16]                 |


**d8** - stays for 8 bit signed immediate displacement (for example: 22, 55h, -1)
**d16** - stays for 16 bit signed immediate displacement (for example: 300, 5517h, -259).


Displacement can be a immediate value or offset of a variable, or even both. If there are several values, assembler evaluates all values and calculates a single immediate value.

> [!Faq]
> Displacement is a **signed** value, so it can be both positive or negative.


> [!Info]- Memory Address Calculation
> For example, let's assume that **DS = 100**, **BX = 30**, **SI = 70**.
> The following addressing mode: $[BX + SI] + 25$
> Is calculated by processor to this physical address: $100 * 16 + 30 + 70 + 25 = 1725$
> 
> There is an easy way to remember all those possible combinations using this chart:
> ![[addressing_mode.gif]]
> 
> All valid combinations can be formed by taking only one item from each column or skipping the column by not taking anything from it. **BX** and **BP** never go together. Neither **SI** and **DI** do.
> 
> Examples of valid addressing modes:  
> - **[BX+5]**  
> - **[BX+SI]**  
> - **[DI+BX-4]**
>   
>   The value in segment register (CS, DS, SS, ES) is called a **segment**, and the value in general purpose register (BX, SI, DI, BP) is called an **offset**.  
>   When DS contains value **1234h** and SI contains the value **7890h** it can be also recorded as **1234:7890**. The physical address will be 1234h * 10h + 7890h = 19BD0h.  
>   
>   If zero is added to a decimal number it is multiplied by 10, however **10h = 16**, so If zero is added to a hexadecimal value, it is multiplied by 16, for example: 
>   
>   7h = 7  
>   70h = 112
