# LinearSensitivity

## **_Have you ever_**

- Wonder "Why is 200% sensitivity not twice as fast as 100%" **?**
- Change your DPI and can't find optimal sens **?**
- Find Minecraft's sensitivity setting is terrible **?**

### **_Then Fear Not!_**

## **Linear Sensitivity** is for you!

Normally, Minecraft handles mouse sensitivity as a cubic function:\
<img src="https://cdn.modrinth.com/data/E8FRI3Kl/images/7a08401568d54f4331ae4e9c51bd7995d9e3c813.png" alt="Why? Minecraft?">

This mod change it. Instead of a cubic function, the sensitivity will be processed in a linear scale. So now, if you change your DPI from 400 up-to 1600, and your sens from 200% down-to 50%, you will feel exactly the same!

## **_Bonus Feature:_**

`/sens` to change your sensitivity (Max: 1, Min: 0), based on [advSensitivity](https://modrinth.com/mod/advsensitivity).

## **_Why I create this mod?_**

Long time ago, when I modify Timeless and Classic mod (the original on 1.18.2 one, not TAC:Z), I find zoom sensitivity is so wrong (it's faster than I expect). After 3 hours digging through the code, I found that the way Minecraft process mouse sens is so weird compared to other games. So I decide to create a mod to change it. After all, I'm a CS player who have fun when creating config files instead of actually playing the game.

## **_Technical detail_**

I use a single mixin class to change a variable in `updateMouse()` method.

## **_Planning_**

- Custom /m_yaw and /m_pitch like CS2, bonus, /fov
