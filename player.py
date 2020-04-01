
class Player(object):
    def __init__(self,hand, name):
        self.hand = [None, None, None, None, None]
        self.name = str(name)
        
        for card in hand:
            self.hand.append(card)
    def computeTotal(self):
        total = 0
        for card in range(self.getNonNullHandLength()):
            if self.hand[card] is None:
                continue
            if(self.hand[card].cardNo == "A"):
                if(total+ 11 <=21):
                    total += 11
                else:
                    total += 1
            else:
                total += self.hand[card].value
        return total

            

    def draw(self, deck):
        drawnCard = deck.draw()
        for card in range(len(self.hand)):
            if self.hand[card] is None:
                self.hand[card] = drawnCard
                print(self.name + " drew ",self.hand[card])
                self.computeTotal()
                break
        

    def getNonNullHandLength(self):
        count = 0
        for i in range(len(self.hand)):
            if (self.hand[i] is not None):
                count+= 1
        return count
    
    def checkGameOver(self):
        if self.computeTotal() > 21: 
            return True
        else:
            return False
    
    def clearHand(self):
        for card in self.hand:
            card = None
        self.computeTotal()

    def printHand(self):
        s1 = ""
        for card in self.hand:
            if(card != None):
                s1 += str(card) + ", "
        print(s1)

class Dealer(Player):
    def decision_maker(self,player):
        while True:
            if self.computeTotal() >= 21:
                break
            if self.computeTotal() < 17:
                self.draw()
            elif self.computeTotal() < player.computeTotal() and self.computeTotal() < 21:
                self.draw()
            
    def printHand(self):
        for card in self.hand:
            if card != None:
                print(str(card))
                break

        
            
        
        
