wait(Pattern("1590592315805.png").similar(0.88))
find(Pattern("1590592315805.png").similar(0.89))
click(Pattern("1590592720187.png").similar(0.84).targetOffset(414,-13))
wheel(WHEEL_UP, 4)
wait("1590590431472.png")
click(Pattern("1590590431472.png").targetOffset(35,0))
type("a", KeyModifier.CTRL)
type(Key.BACKSPACE)
type("Q8 Ventimiglia Sud")
wait("1590590852756.png")
click("1590590475520.png")
click("1590590484219.png")
click("1590590499569.png")
wheel(WHEEL_DOWN, 4)
wait(Pattern("1590592356467.png").similar(0.86))