# Translate/translate core code to other languages
# Task Description
The core code should be translated to other programming languages,
in order to keep the code portable and compatible to a wide range of programming paradigms.
The goal of being compatible of many programming paradigms,
is to support as many valid concerns regarding the code's property as possible.

This may be a service task in the future,
that ensures,
that this property is adhered to.
# Tasks
* [ ] Create basis for Translation. Use JavaParser for translation only instead of the Java grammer,
  in order to support some standard Java things/classes/method via name resolution
  without creating own wrapper interfaces and objects.
* [ ] Translate to Dlang, as this is a different language, but has much in common with Java.
* [ ] Translate to Rust, in order to introduce lifetime management of side effects.
* [ ] Translate to OCaml, in order to support side effect freedom, if possible.