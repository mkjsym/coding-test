### List
|List|`add`|`remove`|`get`|`contains`||
|:---:|:---:|:---:|:---:|:---:|---|
|**`ArrayList`**|O(1)|O(n)|O(1)|O(n)|
|**`LinkedList`**|O(1)|O(1)|O(n)|O(1)|


### Set
|Set|`add`|`remove`|`contains`|`next`|`size`||
|:---:|:---:|:---:|:---:|:---:|:---:|---|
|**`HashSet`**|O(1)|O(1)|O(1)|O(h/n)|O(1)|
|**`LinkedHashSet`**|O(1)|O(1)|O(1)|O(1)|O(1)|등록순으로 정렬|
|**`TreeSet`**|O(log n)|O(log n)|O(log n)|O(log n)|O(1)|객체 기준 정렬|
|**`EnumSet`**|O(1)|O(1)|O(1)|O(1)|O(1)|


### Map
|Map|`put`|`get`|`containsKey`|`next`||
|:---:|:---:|:---:|:---:|:---:|:---:|
|**`HashMap`**|O(1)|O(1)|O(1)|O(h/n)|
|**`LinkedHashMap`**|O(1)|O(1)|O(1)|O(1)|순서대로 등록되는 map|
|**`TreeMap`**|O(log n)|O(log n)|O(log n)|O(log n)|정렬된 map. null 허용x|
|**`EnumMap`**|O(1)|O(1)|O(1)|O(1)|
