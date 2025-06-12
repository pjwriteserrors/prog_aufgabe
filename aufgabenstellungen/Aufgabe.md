# Aufgaben (LinkedList)

Diese Aufgaben basieren auf einer abgewandelten Musterlösung der Präsenzübung 06.
Es ist empfehlenswert sich mit den Inhalten der Präsenzübung vertraut zu machen, dies ist jedoch nicht notwendig.

## a)

Implementieren sie die Methoden `public void addI(Integer data, int i)` und `public void removeI(int i)` in der Klasse `ExtendedLinkedList`.

Die Methode `addI` soll an der Position `i` (Zählung beginnen bei Position $0$) das Element `data` einfügen.
Wenn `i<0` oder `i>size` ist, dann soll eine `IndexOutOfBoundsException` ausgegeben werden. Wenn `i=size` ist, soll `data` an das Ende der Liste hinzufügt werden.

Die Methode `removeI` soll das Element an der Position `i` entfernen (Zählung beginnen bei Position $0$).
Wenn `i<0` oder `i>size` ist, dann soll eine `IndexOutOfBoundsException` ausgegeben werden.

## b)

Implementieren Sie die Methode `public void combineLists(ExtendedLinkedList list2)` in der Klasse `ExtendedLinkedList`.
Die Methode soll die übergebene Liste `list2` an die Liste des Objektes anhängen.

Beispiel: Falls `l` die Liste [1,2,3] ist und `list2` die Liste [4,5,6] darstellt, soll nach dem Aufruf `l.combineLists(list2)` die Liste `l` folgende Liste sein: [1,2,3,4,5,6]. Die Liste `list2` soll dabei unverändert bleiben.

## c)

Implementieren Sie die Methoden `public boolean isSorted()` und `public void addSorted(Integer data)` in der Klasse `ExtendedLinkedList`.
Die Methode `isSorted` soll dabei einen `boolean` zurückgeben, ob die Liste sortiert ist. Also entweder `true` (falls die Liste sortiert ist) oder `false` (falls die Liste nicht sortiert ist).

Die Methode `addSorted` wird nur bei sortierten Listen aufgerufen. Diese soll das Element `data` in die Liste des Objektes an der korrekten Position einfügen, sodass die Liste nach dem Einfügen des neuen Elements `data` immer noch sortiert ist.

Wichtig: Sie sollen also für `addSorted` nicht noch eine Methode implementieren, die die Liste sortiert. Falls die Liste nicht sortiert ist, soll eine `UnsupportedOperationException` zurückgegeben werden.

Beispiel: Falls `l` die Liste [1,5,9] ist und `data` das Element 3 ist, soll soll nach dem Aufruf `l.addSorted(3)` die Liste `l` folgende Liste sein: [1,3,5,9].

## d)

Implementieren Sie die Methode `public ExtendedLinkedList filterElements(Callable<Integer> func)` in der Klasse `ExtendedLinkedList`.

Diese Methode soll ein Objekt, welches das Interface `Callable<Boolean, Integer>` implementiert übergeben bekommen.
Es soll nun mithilfe der Funktion `evaluate` aus dem Objekt alle Listenelemente in eine neue Liste gespeichert werden, für die die Funktion `true` zurückgibt.
Die Originalliste soll dabei unverändert bleiben.

Als Beispiel Filter ist die Klasse `positiveFilter` implementiert.

## e)

Nutzen Sie die Methode `filterElements` aus Aufgabenteil d), um die Methoden `public ExtendedLinkedList evenElements()`, `public ExtendedLinkedList oddElements()`, `public ExtendedLinkedList positiveElements()` und  `public ExtendedLinkedList negativeElements()` zu implementieren.

Die Methoden sollen dabei folgende Aufgaben erfüllen:

- `evenElements`: Gibt eine neue Liste nur mit den geraden Elementen zurück. Implementieren Sie dafür die Klasse `evenFilter`.
- `oddElements`: Gibt eine neue Liste nur mit den ungeraden Elementen zurück. Implementieren Sie dafür die Klasse `oddFilter`.
- `positiveElements`: Gibt eine neue Liste nur mit den positiven Elementen zurück. Nutzen Sie dafür die Klasse `positiveFilter`.
- `negativeElements`: Gibt eine neue Liste nur mit den negativen Elementen zurück. Implementieren Sie dafür die Klasse `negativeFilter`.

## f)

Implementieren Sie die Methode `public void rotation(int i, String direction)` in der Klasse `ExtendedLinkedList`.

Die Methode soll die Elemente um `i` Elemente rotieren. Dabei sollen Elemente die hinten oder vorne "rausfallen" wieder an der entsprechend anderen Seite eingefügt werden.
Der Wert von `i` darf dabei auch grösser sein, als die Liste lang ist.

Der String `direction` gibt an ob nach links oder rechts rotiert wird. Der String darf entweder `left` oder `right` sein. Falls andere String übegeben werden soll eine `UnsupportedOperationException` geworfen werden.

Achten Sie darauf, dass die Methode auch bei Listen mit 0 oder einem Element funktioniert.
Beispiel: Falls `l` die Liste [1,2,3,4] ist, `i` 2 ist und `String` `right` ist, soll nach dem Aufruf `l.rotation(2, "right")` die Liste `l` folgende Liste sein [3, 4, 1, 2]

Beispiel: Falls `l` die Liste [4,1,9,2,5] ist, `i` 8 ist und `String` `left` ist, soll nach dem Aufruf `l.rotation(8, "left")` die Liste `l` folgende Liste sein [2,5,4,1,9]

## g)

Implementieren Sie die Methode `public void removeDuplicates()` in der Klasse `ExtendedLinkedList`.

Diese soll die Liste so verändern, dass keine Werte mehr in der Liste mehrmals vorkommen. Die Methode soll immer das erste Vorkommen behalten.

**Tipp** Diese Methode kann mit einem Filter intelligent gelöst werden. Ihnen steht es Frei dafür den Filter `duplicateFilter` im Package `filters` zu implementieren und diesen zu nutzen. Dies ist nicht notwendig um die Aufgabe zu lösen.

## h)

Implementieren Sie die Methode `public ExtendedLinkedList map(Callable<Integer, Integer> m)` in der Klasse `ExtendedLinkedList`.

Diese Methode soll ähnlich wie `map` in Python auf der aufgerufenen Liste bei jedem Element die Methode `evaluate` aus `m` aufrufen und die Ergebnisse in einer neuen Liste speichern.
Als Beispielfunktionen ist die Klasse `addI` gegeben, welche für das addieren eines Festen wertes gedacht ist. Implementieren Sie die Klasse `multiplyI`, welche um einen festen Wert multipliziert.
