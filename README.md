invoiceApp
==========

Build: _1.4.3_
- ujkiallito hozzaadasa megy
- ujtermekhozzaadas megy


-- Deadline -- Build: _1.4.4_

    - CurrencyConverter : kész
    - Formatter (Számok formázására) : kész
    - Tétel hozzáadása(Products-ból) : kész
    - Kiállitó hozzáadása : Javitva - kész

TODO: TableModel generálása Products-ból és Invoice-ból(pl Sztorno számlához)
      Invoice mentése adatbázisba
      TableModel készitése főablakra
      Nyomtatás - PDF mentés
      Mezők validálása
      Apróságok

Nem tudtam befejezni.

--- Megjegyzések ---

Hard-Coded Mysql connection -> saját gépemen futó mysql szerverhez
A CurrencyConverter Google API-t használ. Bármilyen pénznembe konvertál. (!nem ellenőrzi, hogy létezik-e a pénznem)

__GitHub__
https://github.com/Szil/invoiceApp