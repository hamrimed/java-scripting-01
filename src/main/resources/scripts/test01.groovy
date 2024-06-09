StringJoiner result = new StringJoiner("");

for (int i = 0; i<10; i++){
    result.add("test"+1);
    result.add("\n");
}
return result.toString();
