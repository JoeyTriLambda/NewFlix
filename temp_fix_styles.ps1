$path = 'c:/Users/oully/Documents/NewFlix/NewFlix-project/app/src/main/res/values/styles.xml'
$content = Get-Content -Raw -LiteralPath $path
$repl = @{
    'android:textStyle">0x0' = 'android:textStyle">normal'
    'android:textStyle">0x1' = 'android:textStyle">bold'
    'android:textStyle">0x2' = 'android:textStyle">italic'
    'android:windowSoftInputMode">0x10' = 'android:windowSoftInputMode">adjustResize'
    'android:windowSoftInputMode">0x20' = 'android:windowSoftInputMode">adjustPan'
    'android:gravity">0x10' = 'android:gravity">center_vertical'
    'android:layout_gravity">0x10' = 'android:layout_gravity">center_vertical'
    'android:gravity">0x11' = 'android:gravity">center'
    'android:layout_gravity">0x11' = 'android:layout_gravity">center'
    'android:gravity">0x1' = 'android:gravity">center_horizontal'
    'android:layout_gravity">0x1' = 'android:layout_gravity">center_horizontal'
    'android:gravity">0x15' = 'android:gravity">center_vertical|end'
    'android:scrollbars">0x200' = 'android:scrollbars">vertical'
    'android:inputType">0x2001' = 'android:inputType">text|textCapWords'
    'android:inputType">0x2' = 'android:inputType">number'
    'android:textAlignment">5' = 'android:textAlignment">viewStart'
}
foreach($k in $repl.Keys){
    $content = $content -replace [regex]::Escape($k), $repl[$k]
}
Set-Content -LiteralPath $path -Value $content
