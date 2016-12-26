from PIL import Image
from random import randint

img = Image.open("./01.png")

width, height = img.size

rand = randint(1,254)
for y in range(height):
    for x in range(width):
		rgba = img.getpixel((x, y))
		if(rgba[3] != 0):

			rgba = ((rgba[0]+rand),  # R
					(rgba[1]+rand),  # G
					(rgba[2]+rand),  # B
					rgba[3]);  # A
			img.putpixel((x, y), rgba)

img.show()
# img.save("/Users/HPJ_1996/Desktop/new.png")
