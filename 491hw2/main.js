
function Background(game) {
  //  this.animation = new Animation(ASSET_MANAGER.getAsset("./img/bg.png"), 0, 0, 768, 520, 100, 1, true, false);
    Entity.call(this, game, 0, 0);
    this.radius = 200;
}

Background.prototype = new Entity();
Background.prototype.constructor = Background;

Background.prototype.update = function () {
}

Background.prototype.draw = function (ctx) {

    ctx.drawImage(ASSET_MANAGER.getAsset("./img/fullBG2.png"), 0, 0);

    Entity.prototype.draw.call(this);
}

// hp bar
function HPBar(game) {
    this.animation = new Animation(ASSET_MANAGER.getAsset("./img/hpBar1.png"), 0, 0, 100, 10, 100, 7, true, false);
    this.wall = 0;
    this.hpBar = 0;

    Entity.call(this, game, 300, 120);

    this.radius = 200;
}

HPBar.prototype = new Entity();
HPBar.prototype.constructor = Background;

HPBar.prototype.update = function () {
    if (this.hpBar !== 6) {
        if (this.wall === 0)
            this.x += 3;
        else this.x -= 3;

        if (this.x >= 700)
            this.wall = 1;
        if (this.x <= 0)
            this.wall = 0;
    }

    Entity.prototype.update.call(this);
}

HPBar.prototype.draw = function (ctx) {
    if (this.game.entities[1].alive) // no show after tank is destroyed
        this.animation.drawFrame(this.game.clockTick, ctx, this.x, this.y, 0, 1, this.hpBar);

    Entity.prototype.draw.call(this);
}


// the "main" code begins here
var ASSET_MANAGER = new AssetManager();

ASSET_MANAGER.queueDownload("./img/bg1.png");
ASSET_MANAGER.queueDownload("./img/bg2.png");
ASSET_MANAGER.queueDownload("./img/bg3.png");
ASSET_MANAGER.queueDownload("./img/score.png");
ASSET_MANAGER.queueDownload("./img/blackHawk.png");
ASSET_MANAGER.queueDownload("./img/bullet2.png");
ASSET_MANAGER.queueDownload("./img/tank.png");
ASSET_MANAGER.queueDownload("./img/gun.png");
ASSET_MANAGER.queueDownload("./img/enemy2.png");
ASSET_MANAGER.queueDownload("./img/enemy3.png");
ASSET_MANAGER.queueDownload("./img/boss1.png");
ASSET_MANAGER.queueDownload("./img/meteor_small.png");
ASSET_MANAGER.queueDownload("./img/meteor.png"); 
ASSET_MANAGER.queueDownload("./img/fireBall1.png");
ASSET_MANAGER.queueDownload("./img/rocketFull.png");
ASSET_MANAGER.queueDownload("./img/explosion2.png");
ASSET_MANAGER.queueDownload("./img/hpBar1.png");
ASSET_MANAGER.queueDownload("./img/fullBG2.png"); 
ASSET_MANAGER.queueDownload("./img/finalExplosion.png");

ASSET_MANAGER.downloadAll(function () {
    console.log("starting up da sheild");
    var canvas = document.getElementById('gameWorld');
    canvas.setAttribute('tabindex', '0');
    canvas.focus();
    var ctx = canvas.getContext('2d');
    
    //////////////////////



    ////////////////////////
    var gameEngine = new GameEngine();

    
    //var bg = new Background(gameEngine);
    var score = new Score(gameEngine);
    var mainCraft = new MainCraft(gameEngine);
    var score = new Score(gameEngine);

    // enemy spaceship
    var enemy = new Enemy(gameEngine);
    var gun = new Gun(gameEngine);
    var enemy2 = new Enemy2(gameEngine);
    var enemy3 = new Enemy3(gameEngine);

    // background
    var bg = new Background(gameEngine);
    var bg1 = new ScrollBG1(gameEngine);
    var bg2 = new ScrollBG2(gameEngine);
    var bg3 = new ScrollBG3(gameEngine);
    // boss
    var boss1 = new Boss(gameEngine);
    // rocks
    var rock1 = new Metero(gameEngine);
    var rock2 = new Metero(gameEngine);

    // bullets
    var fireBall = new FireBall(gameEngine);
    var rocket = new Rocket(gameEngine);

    // HP bar
    var hp = new HPBar(gameEngine);

    // adding background
    gameEngine.addEntity(bg);
    //gameEngine.addEntity(bg1);
    //gameEngine.addEntity(bg2);
    //gameEngine.addEntity(bg3);

    // adding boss and ememies
   // gameEngine.addEntity(boss1);
    //gameEngine.addEntity(rock1);
    //gameEngine.addEntity(rock2);
    gameEngine.addEntity(enemy);
    gameEngine.addEntity(hp);
    gameEngine.addEntity(gun);

    //gameEngine.addEntity(enemy2);
    //gameEngine.addEntity(enemy3);

    
    gameEngine.addEntity(fireBall);
    gameEngine.addEntity(rocket);
    gameEngine.addEntity(mainCraft);
    //gameEngine.addEntity(score);

    gameEngine.init(ctx);
    gameEngine.start();
});
