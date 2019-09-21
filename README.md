# Block Factory

This mod registers blocks and simple items based on files inside the
`block-factory` folder, inside the mc directory, or inside the static_data directory of a mod jar.

You can register a new block like 
this:`block-factory/blocks/<namespace>/<block-name>.json`

The current json format:
These are the default values, any of these fields can be omitted.

List of available materials can be found here.
https://github.com/Frontrider/block-factory/blob/master/src/main/java/hu/frontrider/blockfactory/data/Materials.java

```
{

  "material": "STONE",
  //controls how the block should be rendered. Set it to TRANSPARENT if it's not a full block.
  "renderLayer": "SOLID",
  //set to false if nothing should spawn on it
  "canSpawnMobs":true,
  "isAir":false,
  //max 15, the amount of light that this block can emit.
  "lightLevel": 0,
  "isInvisible": false,
  "hardness": 1.0,
  //set it to false if the player should to collide with it.
  "isCollideable": true,
  //set to false if this block has no item.
  "hasItem": true,
  //weather or not this block should tick randomly, like leaves. 
  //this is here, so you can hook up things like the functions with the function API.
  "ticksRandomly":false,
  //NORMAl,STAIRS,SLAB,FENCE.
  //use fence for walls.
  "type":"NORMAl"
}
```

For an item put a json file under:
`block-factory/items/<namespace>/<item-name>.json`

Currently, you can only set the count
```json
{
"count":64
}
```
